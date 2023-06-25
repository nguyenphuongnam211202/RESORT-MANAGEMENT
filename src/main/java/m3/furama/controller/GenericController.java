package m3.furama.controller;

import m3.furama.service.GenericService;
import m3.furama.util.CommonUtil;
import m3.furama.util.paging.PageHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/employee", "/customer"})
public class GenericController extends HttpServlet {
    private GenericService genericService = new GenericService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String entityName = req.getServletPath().substring(1);
        genericService.setEntityName(entityName);

        if (req.getMethod().equals("GET")) {
            req.setAttribute("result", genericService.findAll(PageHelper.PageRequest(req)));
            req.getRequestDispatcher(entityName + ".tiles").forward(req, resp);
        } else {
            int id = CommonUtil.toInt(req.getParameter("id"));
            if (req.getParameter("action") != null) {
                genericService.delete(id);
            } else {
                genericService.save(CommonUtil.mapToObject(req));
            }

            resp.sendRedirect("/customer");
        }
    }
}
