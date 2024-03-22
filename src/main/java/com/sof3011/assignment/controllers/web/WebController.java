package com.sof3011.assignment.controllers.web;

import com.sof3011.assignment.services.IProductService;
import com.sof3011.assignment.utils.ContextUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(value = "/")
public class WebController extends HttpServlet {
    private final IProductService productService = ContextUtil.getBean(IProductService.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("top5Product",productService.getTop5NewestProduct());
        req.getRequestDispatcher("WEB-CONTENT/pages/web/home.jsp").forward(req,resp);
    }
}
