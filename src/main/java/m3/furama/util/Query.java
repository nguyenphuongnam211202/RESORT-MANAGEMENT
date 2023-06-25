package m3.furama.util;

import m3.furama.util.annotation.Extra;
import m3.furama.util.annotation.IsAssociate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

public class Query {
    public static String entityName;

    public static String findAll() {
        String tmp = "";

        try {
            List<Field> fields = CommonUtil.getAllFields(CommonUtil.getClazz(entityName));
            for (Field f : fields) {
                Annotation annotation = f.getAnnotation(IsAssociate.class);
                if (annotation instanceof IsAssociate) {
                    IsAssociate isAssociate = (IsAssociate) annotation;
                    String a = entityName + "." + CommonUtil.convertToSnakeCase(f.getName());
                    String b = isAssociate.table() + ".id";
                    tmp += String.format(" join %s on %s = %s", isAssociate.table(), a, b);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return String.format("select * from %s %s order by %s.id desc", entityName, tmp, entityName);
    }

    public static String findAllWithPaging() {
        return findAll() + " limit ?lim offset ?off";
    }

    public static String insert() {
        return "";
    }

    public static String update() {
        try {
            List<Field> fields = CommonUtil.getAllFields(CommonUtil.getClazz(entityName));
            fields.removeIf(e-> e.getAnnotation(Extra.class) instanceof Extra);
            String tmp = fields.stream().map(e -> e.getName() + "=?").skip(1).collect(Collectors.joining(","));
            return String.format("update %s set %s where id = ?", entityName, tmp);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    public static String delete() {
        return "delete from " + entityName + " where id = ?";
    }
}
