package m3.furama.util.tag;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.tagext.TagSupport;

public class TableTag  extends TagSupport {
    private String header;
    private String column;
    private Object result;

    public void setHeader(String header) {
        this.header = header;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public int doStartTag() {
        try {
            ServletRequest request= pageContext.getRequest();
            request.setAttribute("headers", header.split(","));
            request.setAttribute("columns", column.split(","));
            request.setAttribute("result", result);

            pageContext.include("/view/element/table.jsp");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return SKIP_BODY;
    }
}
