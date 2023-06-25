package m3.furama.util.tag;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import m3.furama.service.GenericService;
import m3.furama.util.Data;
import m3.furama.util.DataField;
import m3.furama.util.CommonUtil;
import m3.furama.util.annotation.Extra;
import m3.furama.util.annotation.IsAssociate;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.tagext.TagSupport;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class AddEditTag extends TagSupport {
    GenericService genericService = new GenericService();
    private String name;
    private String exclude;
    private String radio;
    private String checkbox;
    private String select;

    public void setName(String name) {
        this.name = name;
    }

    public void setExclude(String exclude) {
        this.exclude = exclude;
    }

    public void setRadio(String radio) {
        this.radio = radio;
    }

    public void setCheckbox(String checkbox) {
        this.checkbox = checkbox;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    @Override
    public int doStartTag() {
        try {
            ServletRequest request = pageContext.getRequest();
            List<Field> fields = CommonUtil.getAllFields(CommonUtil.getClazz(name));
            ObjectMapper objectMapper = new ObjectMapper();

            List<DataField> radios = new ArrayList<>();
            if (radio != null) {
                radios = objectMapper.readValue(radio, new TypeReference<List<DataField>>() {
                });
                request.setAttribute("radios", radios);
            }

            List<DataField> checkboxs = new ArrayList<>();
            if (checkbox != null) {
                checkboxs = objectMapper.readValue(checkbox, new TypeReference<List<DataField>>() {
                });
                request.setAttribute("checkboxs", checkboxs);
            }

            List<DataField> selects = new ArrayList<>();
            if (select != null) {

                String[] tmp = select.split(",");
                for (int i = 0; i < tmp.length; i++) {

                    String table ="";
                    for (Field f : fields) {
                        Annotation annotation = f.getAnnotation(IsAssociate.class);
                        if (annotation instanceof IsAssociate && f.getName().equals(tmp[i])) {
                            table = ((IsAssociate) annotation).table();
                        }
                    }
                    genericService.setEntityName(table);

                    ArrayList<Data> al = new ArrayList<>();
                    List<Object>  list = genericService.findAll();
                    for (int j = 0; j < list.size(); j++) {
                        String key = CommonUtil.getValueByField(list.get(j), "name").toString();
                        String value = CommonUtil.getValueByField(list.get(j), "id").toString();
                        al.add(new Data( key, value));
                    }

                    DataField dataField = new DataField(tmp[i], CommonUtil.convertToCamelCase(table));
                    dataField.setData(al);
                    selects.add(dataField);
                }

                request.setAttribute("selects", selects);
            }

            String[] excludes;
            if (exclude != null) {
                excludes = exclude.split(",");
                for (int i = 0; i < excludes.length; i++) {
                    String tmp = excludes[i];
                    fields.removeIf(e -> e.getName().equals(tmp));
                }
            }

            for (int i = 0; i < radios.size(); i++) {
                String tmp = radios.get(i).getField();
                fields.removeIf(e -> e.getName().equals(tmp));
            }

            for (int i = 0; i < checkboxs.size(); i++) {
                String tmp = checkboxs.get(i).getField();
                fields.removeIf(e -> e.getName().equals(tmp));
            }

            for (int i = 0; i < selects.size(); i++) {
                String tmp = selects.get(i).getField();
                fields.removeIf(e -> e.getName().equals(tmp));
            }

            fields.removeIf(e-> e.getAnnotation(Extra.class) instanceof Extra);

            request.setAttribute("name", name);
            request.setAttribute("fields", fields);
            pageContext.include("/view/element/addEdit.jsp");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return SKIP_BODY;
    }
}
