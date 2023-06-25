package m3.furama.controller;

import m3.furama.model.Service;
import m3.furama.service.ServiceService;
import m3.furama.service.ServiceServiceImpl;
import m3.furama.util.CommonUtil;
import m3.furama.util.paging.PageHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServiceController", value = "/service")
public class ServiceController extends HttpServlet {
    private ServiceService serviceService= new ServiceServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("result", serviceService.findAll(PageHelper.PageRequest(req)));
        req.getRequestDispatcher("service.tiles").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int res = id > 0 ? serviceService.delete(id) : serviceService.save(mapToService(req));
        resp.sendRedirect("/service?m="+ res);
    }

    private Service mapToService(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int area = CommonUtil.toInt(request.getParameter("area"));
        Double price = CommonUtil.toDouble(request.getParameter("price"));
        int maxPeople = CommonUtil.toInt(request.getParameter("maxPeople"));
        String standarRoom = request.getParameter("standarRoom");
        int poolArea = CommonUtil.toInt(request.getParameter("poolArea"));
        int floorNumber = CommonUtil.toInt(request.getParameter("floorNumber"));
        int serviceTypeId = CommonUtil.toInt(request.getParameter("serviceType"));
        int rentTypeId = CommonUtil.toInt(request.getParameter("rentType"));

        return new Service(id, name, area, price, maxPeople, standarRoom, "", poolArea, floorNumber, serviceTypeId, rentTypeId, "");
    }
}
