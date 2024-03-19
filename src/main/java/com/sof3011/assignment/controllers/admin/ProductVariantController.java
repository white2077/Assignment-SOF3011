package com.sof3011.assignment.controllers.admin;

import com.sof3011.assignment.entities.Product;
import com.sof3011.assignment.services.IProductAttributeService;
import com.sof3011.assignment.services.IProductService;
import com.sof3011.assignment.services.IProductVariantService;
import com.sof3011.assignment.services.impl.ProductAttributeService;
import com.sof3011.assignment.services.impl.ProductService;
import com.sof3011.assignment.services.impl.ProductVariantService;
import com.sof3011.assignment.utils.ContextUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = {"/admin/product/add-product-variant-page",
        "/admin/product/add-product-variant"})

public class ProductVariantController extends HttpServlet {
    private final IProductVariantService variantRepository = ContextUtil.getBean(ProductVariantService.class);
    private final IProductService productService = ContextUtil.getBean(ProductService.class);
    private final IProductAttributeService productAttributeService = ContextUtil.getBean(ProductAttributeService.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String slug = req.getParameter("product");
        Product product = productService.getBySlug(slug);
        req.setAttribute("productName", product.getProductName());
        req.getRequestDispatcher("/WEB-CONTENT/pages/admin/product-variant-form.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.equals("/admin/product/add-product-variant")){
            resp.sendRedirect("/admin/products");
        }
    }
}
