package m3.furama.util;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CommonUtil {
    public static int toInt(String val) {
        try {
            return Integer.parseInt(val);
        } catch (Exception e) {
            return 0;
        }
    }

    public static Double toDouble(String val) {
        try {
            return Double.parseDouble(val);
        } catch (Exception e) {
            return 0.0;
        }
    }

    public static Class getClazz(String entityName) {
        String path = "m3.furama.model." + convertToCamelCase(entityName);
        try {
            return Class.forName(path);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<Field> getAllFields(Class clazz) {
        if (clazz == null) {
            return Collections.emptyList();
        }

        List<Field> result = Arrays.stream(clazz.getDeclaredFields())
                .collect(Collectors.toList());

        return result;
    }

    public static Object getValueByField(Object o, String field) {
        Object result = null;

        try {
            Class<?> clazz = o.getClass();
            Field f = clazz.getDeclaredField(field);
            f.setAccessible(true);
            result = f.get(o);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static String convertToSnakeCase(String val) {
        String regex = "([a-z])([A-Z]+)";
        String replacement = "$1_$2";
        return val.replaceAll(regex, replacement).toLowerCase();
    }

    public static String convertToCamelCase(String str) {
        str = str.substring(0, 1).toUpperCase() + str.substring(1);
        StringBuilder builder = new StringBuilder(str);

        for (int i = 0; i < builder.length(); i++) {
            if (builder.charAt(i) == '_') {
                builder.deleteCharAt(i);
                builder.replace(i, i + 1, String.valueOf(Character.toUpperCase(builder.charAt(i))));
            }
        }

        return builder.toString();
    }

    public static Object mapToObject(HttpServletRequest req){
        String entityName = req.getServletPath().substring(1);
        Class clazz = CommonUtil.getClazz(entityName);
        List<Field> fields = getAllFields(clazz);
        List<String> params = new ArrayList<>();
        for (Field f : fields){
             String name = f.getName();
             params.add(req.getParameter(name));
        }

        return createInstance(clazz, fields, params);
    }

    private static Object createInstance(Class clazz,  List<Field> fields, List<String> params) {
        try {
            Constructor<?> ctor = clazz.getConstructors()[0];
            ctor.setAccessible(true);

            Object[] tmp = new Object[fields.size()];

            for (int i = 0; i < fields.size(); i++) {
                String fileType = fields.get(i).getType().getSimpleName().toLowerCase();
                switch (fileType) {
                    case "int":
                        tmp[i] = Integer.valueOf(params.get(i));
                        break;
                    case "double":
                        tmp[i] = Double.valueOf(params.get(i));
                        break;
                    case "boolean":
                        tmp[i] = Boolean.valueOf(params.get(i));
                        break;
                    case "localdate":
                        tmp[i] = LocalDate.parse(params.get(i));
                        break;
                    default:
                        tmp[i] = params.get(i);
                }
            }

            return ctor.newInstance(tmp);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
