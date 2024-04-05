package com.sof3011.assignment.controllers.web;

import com.sof3011.assignment.entities.OrderDetail;
import com.sof3011.assignment.security.CustomPrincipal;
import com.sof3011.assignment.services.IOrderDetailService;
import com.sof3011.assignment.services.IUserService;
import com.sof3011.assignment.services.impl.OrderDetailService;
import com.sof3011.assignment.services.impl.UserService;
import com.sof3011.assignment.utils.ContextUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(value = "/order-detail")
public class OrderDetailController extends HttpServlet {
    private final IOrderDetailService orderDetailService = ContextUtil.getBean(OrderDetailService.class);
    private final IUserService iUserService = ContextUtil.getBean(UserService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        CustomPrincipal customPrincipal = (CustomPrincipal) session.getAttribute("user");
        req.setAttribute("orderDetails",
                orderDetailService
                        .getbyCustomer(iUserService.getUserByUsername(customPrincipal.getName())));
        req.getRequestDispatcher("/WEB-CONTENT/pages/web/user-order.jsp").forward(req, resp);
    }
}
