package com.sof3011.assignment.controllers.admin;

import com.sof3011.assignment.entities.Product;
import com.sof3011.assignment.services.IProductAttributeService;
import com.sof3011.assignment.services.IProductService;
import com.sof3011.assignment.services.impl.ProductAttributeService;
import com.sof3011.assignment.services.impl.ProductService;
import com.sof3011.assignment.utils.ContextUtil;
import com.sof3011.assignment.utils.SlugUtil;
import com.sof3011.assignment.utils.ValidatorUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@WebServlet(value = {"/admin/products", "/admin/products/add-product","/admin/products/add-new","/admin/products/delete"})
public class ProductController extends HttpServlet {
    private final IProductService productService = ContextUtil.getBean(ProductService.class);
    private final IProductAttributeService productAttributeService = ContextUtil.getBean(ProductAttributeService.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("productAttribute",productAttributeService.getAllParentAttributeProduct());
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
        String uri = req.getRequestURI();
        if (uri.equals("/admin/products/add-new")){
            Set<Long> ids =productAttributeService
                    .getAllProductAttributeSlug()
                    .stream()
                    .map(s ->Long.valueOf(req.getParameter(s)))
                    .collect(Collectors.toSet());
            System.out.println(ids);
            String productName = req.getParameter("productName");
            Product product = Product.builder()
                    .productName(productName)
                    .description(req.getParameter("description"))
                    .slug(SlugUtil.convertNameToSlug(productName))
                    .thumbnail("123")
                    .status(true)
                    .build();
            Map<String,String> violations = ValidatorUtils.validate(product);
            if (!violations.isEmpty()){
                req.setAttribute("productAttribute",productAttributeService.getAllParentAttributeProduct());
                req.setAttribute("violations",violations);
                req.getRequestDispatcher("/WEB-CONTENT/pages/admin/product-form.jsp").forward(req,resp);
            }
            else {
                productService.insert(product);
                resp.sendRedirect("/admin/products");
            }
        }
        if (uri.contains("/admin/products/delete")){
            productService.delete(Long.valueOf(req.getParameter("productId")));
            resp.sendRedirect("/admin/products");
        }
    }

}
