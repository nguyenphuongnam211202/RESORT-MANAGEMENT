package m3.furama.util.tag;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.tagext.TagSupport;

public class DeleteTag extends TagSupport {
    @Override
    public int doStartTag() {
        try {
            ServletRequest request= pageContext.getRequest();
            pageContext.include("/view/element/delete.jsp");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return SKIP_BODY;
    }
}
