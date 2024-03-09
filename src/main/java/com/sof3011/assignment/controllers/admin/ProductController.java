package com.sof3011.assignment.controllers.admin;

import com.sof3011.assignment.services.IProductService;
import com.sof3011.assignment.services.IService;
import com.sof3011.assignment.services.impl.ProductService;
import com.sof3011.assignment.utils.ContextUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = {"/admin/products", "/admin/products/add-product"})
public class ProductController extends HttpServlet {
    private final IProductService productService = ContextUtil.getBean(ProductService.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if (url.equals("/admin/products")) {
            req.setAttribute("products",productService.getAll());
            req.getRequestDispatcher("/WEB-CONTENT/pages/admin/product.jsp").forward(req, resp);
        }
        if (url.equals("/admin/products/add-product")) {
            req.getRequestDispatcher("/WEB-CONTENT/pages/admin/product-form.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        //send params = > name input = 'name' => request.getParams()
    }
}
