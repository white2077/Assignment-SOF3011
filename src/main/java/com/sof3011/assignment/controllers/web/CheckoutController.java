package com.sof3011.assignment.controllers.web;

import com.sof3011.assignment.entities.Cart;
import com.sof3011.assignment.entities.ProductVariant;
import com.sof3011.assignment.services.IProductVariantService;
import com.sof3011.assignment.utils.ContextUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = {"/checkout-page", "/checkout"})
public class CheckoutController extends HttpServlet {
    private final IProductVariantService productVariantService = ContextUtil.getBean(IProductVariantService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("cart") == null) resp.sendRedirect("/");
        else req.getRequestDispatcher("/WEB-CONTENT/pages/web/checkout.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Cart> cart = new ArrayList<>();
        HttpSession session = req.getSession();
        Cart cartItem = Cart
                .builder()
                .productVariant(productVariantService.getById(Long.valueOf(req.getParameter("productVariantId"))))
                .quantity(Integer.parseInt(req.getParameter("quantity")))
                .build();
        cart.add(cartItem);
        session.setAttribute("cart", cart);
        resp.sendRedirect("/checkout-page");
    }
}
