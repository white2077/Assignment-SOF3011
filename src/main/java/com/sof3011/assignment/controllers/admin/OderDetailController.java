package com.sof3011.assignment.controllers.admin;

import com.sof3011.assignment.enums.OrderStatus;
import com.sof3011.assignment.services.IOrderDetailService;
import com.sof3011.assignment.utils.ContextUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(value = {"/admin/order-details","/admin/order-details/view-items","/admin/order-details/update-status"})
public class OderDetailController extends HttpServlet {
    private final IOrderDetailService orderDetailService = ContextUtil.getBean(IOrderDetailService.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if (url.equals("/admin/order-details")){
            req.setAttribute("orderDetails",orderDetailService.getAll());
            req.getRequestDispatcher("/WEB-CONTENT/pages/admin/order-details.jsp").forward(req,resp);
        }
        if (url.equals("/admin/order-details/view-items")){
            Long id = Long.parseLong(req.getParameter("id"));
            req.setAttribute("orderStatus", OrderStatus.values());
            req.setAttribute("orderItems",orderDetailService.getById(id));
            req.setAttribute("orderDetail",orderDetailService.getById(id));
            req.getRequestDispatcher("/WEB-CONTENT/pages/admin/order-items.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if (url.equals("/admin/order-details/update-status")){
            Long id = Long.parseLong(req.getParameter("id"));
            OrderStatus orderStatus = OrderStatus.valueOf(req.getParameter("orderStatus"));
            orderDetailService.updateStatus(id,orderStatus);
            resp.sendRedirect(req.getContextPath()+"/admin/order-details");
        }
    }
}
