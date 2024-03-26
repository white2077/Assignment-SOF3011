package com.sof3011.assignment.controllers.web;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sof3011.assignment.dto.CartDTO;
import com.sof3011.assignment.entities.Cart;
import com.sof3011.assignment.services.ICookieService;
import com.sof3011.assignment.services.impl.CookieService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@WebServlet(value = "/cart")
public class CartController extends HttpServlet {
    private final Gson gson = new Gson();
    private final ICookieService cookieService = new CookieService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cart =  cookieService.getCookie(req, "cart");
        if(cart == null){
            req.setAttribute("carts", null);
        }else{
            String decoded = new String(Base64.getDecoder().decode(cart));
            System.out.println(decoded);
            List<Cart> carts = new Gson().fromJson(decoded, new TypeToken<List<Cart>>() {
            }.getType());
            req.setAttribute("carts", carts);
        }
        req.getRequestDispatcher("/WEB-CONTENT/pages/web/cart.jsp").forward(req, resp);
    }
}
