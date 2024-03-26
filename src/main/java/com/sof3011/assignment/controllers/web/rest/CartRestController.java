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
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


@WebServlet(value = "/add-to-cart")
public class CartRestController extends HttpServlet {
    private final IProductVariantService productVariantService = ContextUtil.getBean(IProductVariantService.class);
    private final ICookieService cookieService = new CookieService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("cart")) {
                byte[] decodedBytes = Base64.getDecoder().decode(cookie.getValue());
                String decodedString = new String(decodedBytes);
                List<Cart> carts = new Gson().fromJson(decodedString, new TypeToken<List<Cart>>() {
                }.getType());
                resp.getWriter().print(new Gson().toJson(carts));
                break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
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
        System.out.println(cartCookie);
        if (cartCookie != null) {
            String decoded = new String(Base64.getDecoder().decode(cartCookie));
            System.out.println(decoded);
            carts = new Gson().fromJson(decoded, new TypeToken<List<Cart>>() {
            }.getType());
            if (carts.stream().anyMatch(c -> c.getProductVariant().getId().equals(cart.getProductVariant().getId()))) {
                for (Cart c : carts) {
                    if (c.getProductVariant().getId().equals(cart.getProductVariant().getId())) {
                        c.setQuantity(c.getQuantity() + cart.getQuantity());
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
    }
    private void saveCookie(List<Cart> carts, HttpServletResponse resp) throws IOException {
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
        String json = gson.toJson(carts);
        String base64String = Base64.getEncoder().encodeToString(json.getBytes());
        Cookie cookie = new Cookie("cart", base64String);
        cookie.setMaxAge(60 * 60 * 24 * 30);
        cookie.setPath("/");
        resp.getWriter().println(json);
        cookie.setHttpOnly(true);
        resp.addCookie(cookie);
    }
}
