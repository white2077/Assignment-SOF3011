package com.sof3011.assignment.controllers.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(value = {"/admin/dash-board","/admin/product"})
public class AdminController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if (url.equals("/admin/dash-board")){
            req.getRequestDispatcher("/WEB-INF/pages/admin/home.jsp").forward(req,resp);
        }
        if (url.equals("/admin/product")){
            req.getRequestDispatcher("/WEB-INF/pages/admin/product.jsp").forward(req,resp);
        }
    }
}
