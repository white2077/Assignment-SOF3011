package com.sof3011.assignment.controllers.admin;

import com.sof3011.assignment.entities.Product;
import com.sof3011.assignment.entities.ProductAttribute;
import com.sof3011.assignment.services.IProductAttributeService;
import com.sof3011.assignment.services.impl.ProductAttributeService;
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

@WebServlet(value = {"/admin/attribute/add-parent-attribute"
        , "/admin/attribute/add-child-product-attribute"
        , "/admin/attribute/add-category",
        "/admin/attribute/all-attributes-page",
        "/admin/attribute/delete-attribute"})
public class ProductAttributeController extends HttpServlet {
    private final IProductAttributeService productAttributeService = ContextUtil.getBean(ProductAttributeService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.equals("/admin/attribute/all-attributes-page")){
            req.setAttribute("productAttribute",productAttributeService.getAllParentAttributeProductVariant());
            req.getRequestDispatcher("/WEB-CONTENT/pages/admin/product-attribute.jsp").forward(req,resp);
        } else if (uri.contains("/admin/attribute/delete-attribute")) {
            productAttributeService.delete(Long.parseLong(req.getParameter("id")));
            resp.sendRedirect("/admin/products/add-product");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("/admin/attribute/add-parent-attribute")) {
            String name = req.getParameter("parentAttributeName");
            ProductAttribute productAttribute = ProductAttribute
                    .builder()
                    .attributeName(name)
                    .attributeType(false)
                    .slug(SlugUtil.convertNameToSlug(name))
                    .build();
            Map<String, String> violations = ValidatorUtils.validate(productAttribute);
            if (!violations.isEmpty()) {
                req.setAttribute("violations", violations);
                req.getRequestDispatcher("/WEB-CONTENT/pages/admin/product-attribute.jsp").forward(req, resp);
            } else {
                productAttributeService.insert(productAttribute);
                resp.sendRedirect("/admin/attribute/all-attributes-page");
            }
        } else if (uri.equals("/admin/attribute/add-child-product-attribute")) {
            String name = req.getParameter("childAttributeName");
            ProductAttribute productAttribute = ProductAttribute
                    .builder()
                    .attributeName(name)
                    .attributeParent(productAttributeService.getById(Long.parseLong(req.getParameter("parentAttributeId"))))
                    .attributeType(true)
                    .slug(SlugUtil.convertNameToSlug(name))
                    .build();
            Map<String, String> violations = ValidatorUtils.validate(productAttribute);
            if (!violations.isEmpty()) {
                req.setAttribute("violations", violations);
                req.setAttribute("productAttribute", productAttributeService.getAllParentAttributeProduct());
                req.setAttribute("productAttribute",productAttributeService.getAllParentAttributeProductVariant());
                req.getRequestDispatcher("/WEB-CONTENT/pages/admin/product-attribute.jsp").forward(req, resp);
            } else {
                productAttributeService.insert(productAttribute);
                resp.sendRedirect("/admin/attribute/all-attributes-page");
            }
        } else if (uri.contains("/admin/attribute/add-category")) {
            ProductAttribute category = productAttributeService.getCategory();
            String name = req.getParameter("categoryName");
            ProductAttribute productAttribute = ProductAttribute
                    .builder()
                    .attributeName(name)
                    .attributeType(null)
                    .slug(SlugUtil.convertNameToSlug(name))
                    .attributeParent(category)
                    .build();
            Map<String,String> violations = ValidatorUtils.validate(productAttribute);
            if (!violations.isEmpty()){
                req.setAttribute("violations", violations);
                req.setAttribute("categories",category);
                req.getRequestDispatcher("/WEB-CONTENT/pages/admin/product-form.jsp").forward(req, resp);
            }
            else{
                productAttributeService.insert(productAttribute);
                resp.sendRedirect("/admin/products/add-product");
            }
        }
    }
}
