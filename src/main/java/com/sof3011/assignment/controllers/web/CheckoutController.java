package com.sof3011.assignment.controllers.web;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sof3011.assignment.entities.Cart;
import com.sof3011.assignment.entities.ProductVariant;
import com.sof3011.assignment.services.ICookieService;
import com.sof3011.assignment.services.IProductVariantService;
import com.sof3011.assignment.services.impl.CookieService;
import com.sof3011.assignment.utils.ContextUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@WebServlet(value = {"/checkout-page", "/checkout","/checkout-cart"})
public class CheckoutController extends HttpServlet {
    private final IProductVariantService productVariantService = ContextUtil.getBean(IProductVariantService.class);
    private final ICookieService cookieService = new CookieService();
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("cart") == null) resp.sendRedirect("/");
        else req.getRequestDispatcher("/WEB-CONTENT/pages/web/checkout.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        HttpSession session = req.getSession();
        List<Cart> carts = new ArrayList<>();
        if (uri.contains("/checkout-cart")) {
            String cartCookie = cookieService.getCookie(req, "cart");
            if (cartCookie != null) {
                String decoded = new String(Base64.getDecoder().decode(cartCookie));
                carts = new Gson().fromJson(decoded, new TypeToken<List<Cart>>() {
                }.getType());
            }
            session.setAttribute("cart", carts);
            resp.sendRedirect("/checkout-page");
        }
        else if(uri.contains("/checkout-page")){
            Cart cartItem = Cart
                    .builder()
                    .productVariant(productVariantService.getById(Long.valueOf(req.getParameter("productVariantId"))))
                    .quantity(Integer.parseInt(req.getParameter("quantity")))
                    .build();
            carts.add(cartItem);
            session.setAttribute("cart", carts);
            resp.sendRedirect("/checkout-page");
        }
    }
}
