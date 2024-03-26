package com.sof3011.assignment.controllers.admin;

import com.sof3011.assignment.services.IOrderDetailService;
import com.sof3011.assignment.utils.ContextUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(value = {"/admin/order-details"})
public class OderDetailController extends HttpServlet {
    private final IOrderDetailService orderDetailService = ContextUtil.getBean(IOrderDetailService.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if (url.equals("/admin/order-details")){
            req.setAttribute("orderDetails",orderDetailService.getAll());
            req.getRequestDispatcher("/WEB-CONTENT/pages/admin/order-details.jsp").forward(req,resp);
        }
    }
}
