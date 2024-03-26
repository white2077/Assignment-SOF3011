package com.sof3011.assignment.controllers.web;

import com.sof3011.assignment.services.IProductService;
import com.sof3011.assignment.services.impl.ProductService;
import com.sof3011.assignment.utils.ContextUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/product/detail")
public class ProductController extends HttpServlet {
    private final IProductService productService = ContextUtil.getBean(ProductService.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String slug = req.getParameter("product");
        req.setAttribute("product",productService.getBySlug(slug));
        req.getRequestDispatcher("/WEB-CONTENT/pages/web/product-details.jsp").forward(req,resp);
    }
}
