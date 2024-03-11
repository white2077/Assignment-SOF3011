package com.sof3011.assignment.controllers.admin;

import com.sof3011.assignment.entities.ProductAttribute;
import com.sof3011.assignment.services.IProductAttributeService;
import com.sof3011.assignment.services.impl.ProductAttributeService;
import com.sof3011.assignment.utils.ContextUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(value = {"/add-parent-attribute"})
public class ProductAttributeController extends HttpServlet {
    IProductAttributeService productAttributeService = ContextUtil.getBean(ProductAttributeService.class);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductAttribute productAttribute = ProductAttribute
                .builder()
                .attributeName(req.getParameter("parentAttributeName"))
                .build();
        productAttributeService.insert(productAttribute);
    }
}
