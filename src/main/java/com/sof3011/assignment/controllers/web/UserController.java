package com.sof3011.assignment.controllers.web;

import com.sof3011.assignment.services.IUserService;
import com.sof3011.assignment.services.impl.UserService;
import com.sof3011.assignment.utils.ContextUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/user/update-info")
public class UserController extends HttpServlet {
    private final IUserService iUserService = ContextUtil.getBean(UserService.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String phone = req.getParameter("phoneNumber");
        String address = req.getParameter("address");
        String fullName = req.getParameter("fullName");
        String uri = req.getRequestURI();
        if (uri.equals("/user/update-info")) {
            resp.sendRedirect("/user/info");
        }
    }
}
