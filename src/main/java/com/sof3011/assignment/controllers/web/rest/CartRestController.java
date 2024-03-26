package com.sof3011.assignment.controllers.web.rest;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.sof3011.assignment.dto.CartDTO;
import com.sof3011.assignment.entities.Cart;
import com.sof3011.assignment.services.ICookieService;
import com.sof3011.assignment.services.IProductVariantService;
import com.sof3011.assignment.services.impl.CookieService;
import com.sof3011.assignment.utils.ContextUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.google.gson.Gson;

@WebServlet(value = {"/add-to-cart","/remove-from-cart","/get-cart","/remove-cart-item"})
public class CartRestController extends HttpServlet {
    private final IProductVariantService productVariantService = ContextUtil.getBean(IProductVariantService.class);
    private final ICookieService cookieService = new CookieService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        String uri = req.getRequestURI();
        if(uri.equals("/get-cart")) {
            String cartCookie = cookieService.getCookie(req, "cart");
            if (cartCookie != null) {
                String decoded = new String(Base64.getDecoder().decode(cartCookie));
                resp.getWriter().println(decoded);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        BufferedReader reader = req.getReader();
        if(uri.equals("/add-to-cart")) {
            StringBuilder jsonStringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonStringBuilder.append(line);
            }
            CartDTO.CartRequest cartRequest = new Gson().fromJson(jsonStringBuilder.toString(), CartDTO.CartRequest.class);
            Cart cart = Cart.builder()
                    .productVariant(productVariantService.getById(cartRequest.getProductVariantId()))
                    .quantity(cartRequest.getQuantity())
                    .build();
            List<Cart> carts = new ArrayList<>();
            String cartCookie = cookieService.getCookie(req, "cart");
            if (cartCookie != null) {
                String decoded = new String(Base64.getDecoder().decode(cartCookie));
                carts = new Gson().fromJson(decoded, new TypeToken<List<Cart>>() {
                }.getType());
                if (carts.stream().anyMatch(c -> c.getProductVariant().getId().equals(cart.getProductVariant().getId()))) {
                    for (Cart c : carts) {
                        if (c.getProductVariant().getId().equals(cart.getProductVariant().getId())) {
                            c.setQuantity(c.getQuantity() + cart.getQuantity());
                            if (c.getQuantity() < 1)
                                carts.remove(c);
                            break;
                        }
                    }
                    saveCookie(carts, resp);
                } else {
                    carts.add(cart);
                    saveCookie(carts, resp);
                }
            }
            else {
                carts.add(cart);
                saveCookie(carts, resp);
            }
            resp.getWriter().println(new Gson().toJson(carts));
        }
    }
    private void saveCookie(List<Cart> carts, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json" );
        Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes f) {
                        return f.getName().equals("productVariantAttributes") || f.getName().equals("product");
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> clazz) {
                        return false;
                    }
                })
                .create();
        resp.getWriter().print(gson.toJson(carts));
        String json = gson.toJson(carts);
        String base64String = Base64.getEncoder().encodeToString(json.getBytes());
        Cookie cookie = new Cookie("cart", base64String);
        cookie.setMaxAge(60 * 60 * 24 * 30);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        resp.addCookie(cookie);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Cart> carts = new ArrayList<>();
            String cartCookie = cookieService.getCookie(req, "cart");
            if (cartCookie != null) {
                String decoded = new String(Base64.getDecoder().decode(cartCookie));
                carts = new Gson().fromJson(decoded, new TypeToken<List<Cart>>() {
                }.getType());
                carts.removeIf(c -> c.getProductVariant().getId().equals(Long.parseLong(req.getParameter("id"))));
                saveCookie(carts, resp);
            }
            resp.getWriter().println(new Gson().toJson(carts));
    }
}
