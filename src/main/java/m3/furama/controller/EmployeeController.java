//package m3.furama.controller;
//
//import m3.furama.service.EmployeeService;
//import m3.furama.service.EmployeeServiceImpl;
//import m3.furama.util.paging.PageHelper;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet(value = "/employee")
//public class EmployeeController extends HttpServlet {
//    private EmployeeService employeeService = new EmployeeServiceImpl();
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("result", employeeService.findAll(PageHelper.PageRequest(req)));
//        req.getRequestDispatcher("employee.tiles").forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//    }
//}
