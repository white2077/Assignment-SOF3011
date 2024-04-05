package com.sof3011.assignment.controllers.auth;

import com.sof3011.assignment.entities.User;
import com.sof3011.assignment.security.CustomPrincipal;
import com.sof3011.assignment.services.IUserService;
import com.sof3011.assignment.services.impl.UserService;
import com.sof3011.assignment.utils.ContextUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = {"/login", "/logout"})
public class AuthController extends HttpServlet {
    private final IUserService userService = ContextUtil.getBean(UserService.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getRequestURI().equals("/login")) {
            req.getRequestDispatcher("/WEB-CONTENT/pages/auth/login.jsp").forward(req, resp);
        } else if (req.getRequestURI().equals("/logout")) {
            req.getSession().invalidate();
            resp.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        CustomPrincipal customPrincipal;
        HttpSession session = req.getSession(false);
        if (session != null) {
                    session.removeAttribute("user");
        }
        if (username != "" && password != "") {
            User userAuthentication = userService.authenticate(username, password);
            if (userAuthentication != null) {
                customPrincipal = new CustomPrincipal(
                        userAuthentication.getUsername(),
                        userAuthentication.getRole().name());
                req.getSession().setAttribute("user",customPrincipal);
            } else {
                req.setAttribute("loginError", true);
                req.getRequestDispatcher("/page/home/login.jsp").forward(req, resp);
                return;
            }
        } else {
            req.setAttribute("loginError", true);
            req.getRequestDispatcher("/page/home/login.jsp").forward(req, resp);
            return;
        }
        if (customPrincipal.isRole("ADMIN")) {
            resp.sendRedirect("/admin/dash-board");
        } else {
            resp.sendRedirect("/home");
        }
    }
}
