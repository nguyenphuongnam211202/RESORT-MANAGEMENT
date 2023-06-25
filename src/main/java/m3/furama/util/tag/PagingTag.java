package m3.furama.util.tag;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.tagext.TagSupport;

public class PagingTag extends TagSupport {
    private Object search;
    private Object params;

    public void setSearch(Object search) {
        this.search = search;
    }

    public void setParams(Object params) {
        this.params = params;
    }

    @Override
    public int doStartTag() {
        try {
            ServletRequest request = pageContext.getRequest();

            if (search.equals(":") || search == null) {
                search = null;
            } else {
                search = "&q=" + search;
            }

            request.setAttribute("search", search);
            request.setAttribute("result", params);

            pageContext.include("/view/element/paging.jsp");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return SKIP_BODY;
    }
}
