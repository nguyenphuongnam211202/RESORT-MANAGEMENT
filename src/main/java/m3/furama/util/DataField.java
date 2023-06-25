package m3.furama.util;

import java.util.ArrayList;

public class DataField {
    private String field;
    public ArrayList<Data> data;;
    public String fieldDisplay;

    public DataField() {
    }

    public DataField(String field, String fieldDisplay) {
        this.field = field;
        this.fieldDisplay = fieldDisplay;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public ArrayList<Data> getData() {
        return data;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }

    public String getFieldDisplay() {
        return fieldDisplay;
    }

    public void setFieldDisplay(String fieldDisplay) {
        this.fieldDisplay = fieldDisplay;
    }
}





