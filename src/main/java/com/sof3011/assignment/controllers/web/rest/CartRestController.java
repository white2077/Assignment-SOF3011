package com.sof3011.assignment.controllers.web.rest;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.sof3011.assignment.dto.CartDTO;
import com.sof3011.assignment.entities.Cart;
import com.sof3011.assignment.entities.User;
import com.sof3011.assignment.security.CustomPrincipal;
import com.sof3011.assignment.services.ICartService;
import com.sof3011.assignment.services.ICookieService;
import com.sof3011.assignment.services.IProductVariantService;
import com.sof3011.assignment.services.IUserService;
import com.sof3011.assignment.services.impl.CartService;
import com.sof3011.assignment.services.impl.CookieService;
import com.sof3011.assignment.services.impl.UserService;
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
    private final IUserService userService = ContextUtil.getBean(UserService.class);
    private final ICartService cartService = ContextUtil.getBean(CartService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        String uri = req.getRequestURI();
        if(uri.equals("/get-cart")) {
            User user = (CustomPrincipal) req.getSession().getAttribute("user") == null ? null : userService.getUserByUsername(((CustomPrincipal) req.getSession().getAttribute("user")).getName());
            if (user == null) {
                String cartCookie = cookieService.getCookie(req, "cart");
                if (cartCookie != null) {
                    String decoded = new String(Base64.getDecoder().decode(cartCookie));
                    resp.getWriter().println(decoded);
                }
                else {
                    resp.getWriter().println("[]");
                }
            }
           else {
                List<Cart> carts = cartService.getCartByUser(user);
              carts.forEach(cart -> {cart.getProductVariant().setProduct(null);
              cart.getProductVariant().setProductVariantAttributes(null);
              cart.getCustomer().setCartItems(null);
              cart.getCustomer().setAddresses(null);
              cart.getCustomer().setOrderDetails(null);});
              resp.getWriter().println(new Gson().toJson(carts));
           }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        BufferedReader reader = req.getReader();
         User user = (CustomPrincipal) req.getSession().getAttribute("user") == null ? null : userService.getUserByUsername(((CustomPrincipal) req.getSession().getAttribute("user")).getName());
        if(uri.equals("/add-to-cart")) {
              if (user == null){
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
              else {
                  StringBuilder jsonStringBuilder = new StringBuilder();
                  String line;
                  while ((line = reader.readLine()) != null) {
                      jsonStringBuilder.append(line);
                  }
                  CartDTO.CartRequest cartRequest = new Gson().fromJson(jsonStringBuilder.toString(), CartDTO.CartRequest.class);
                  if (user.getCartItems().isEmpty()){
                      cartService.addProductToCart(cartRequest.getProductVariantId(), cartRequest.getQuantity(),user);
                  }
                  else {
                      List<Cart> carts = user.getCartItems();
                      if (carts.stream().anyMatch(c -> c.getProductVariant().getId().equals(cartRequest.getProductVariantId()))) {
                          for (Cart c : carts) {
                              if (c.getProductVariant().getId().equals(cartRequest.getProductVariantId())) {
                                  c.setQuantity(c.getQuantity() + cartRequest.getQuantity());
                                  if (c.getQuantity() < 1)
                                      carts.removeIf(cart -> cart.getId().equals(c.getId()));
                                  cartService.removeProductFromCart(c.getId());
                                  break;
                              }
                          }
                          cartService.insertAll(carts);
                      } else {
                          cartService.addProductToCart(cartRequest.getProductVariantId(), cartRequest.getQuantity(), user);
                      }
                  }
              }
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
        User user = (CustomPrincipal) req.getSession().getAttribute("user") == null ? null : userService.getUserByUsername(((CustomPrincipal) req.getSession().getAttribute("user")).getName());
        if (user == null) {
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
        else {
            System.out.println(req.getParameter("id"));
            cartService.removeProductFromCart(Long.parseLong(req.getParameter("id")));
        }
    }
}
