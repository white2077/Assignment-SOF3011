package com.sof3011.assignment.controllers.web;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sof3011.assignment.entities.Cart;
import com.sof3011.assignment.entities.Customer;
import com.sof3011.assignment.entities.OrderDetail;
import com.sof3011.assignment.enums.OrderStatus;
import com.sof3011.assignment.services.ICookieService;
import com.sof3011.assignment.services.IOrderDetailService;
import com.sof3011.assignment.services.IProductVariantService;
import com.sof3011.assignment.services.impl.CookieService;
import com.sof3011.assignment.utils.ContextUtil;
import com.sof3011.assignment.utils.ValidatorUtils;
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
import java.util.Map;

@WebServlet(value = {"/checkout-page", "/checkout","/checkout-cart"})
public class CheckoutController extends HttpServlet {
    private final IOrderDetailService orderDetailService = ContextUtil.getBean(IOrderDetailService.class);
    private final IProductVariantService productVariantService = ContextUtil.getBean(IProductVariantService.class);
    private final ICookieService cookieService = new CookieService();

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
        else
            if(uri.equals("/checkout")){
            List<Cart> cartItems = (List<Cart>) session.getAttribute("cart");
            OrderDetail orderDetail = OrderDetail
                    .builder().customerName(req.getParameter("customerName"))
                    .address(req.getParameter("address"))
                    .district(req.getParameter("district"))
                    .cityOrProvince(req.getParameter("cityOrProvince"))
                    .phoneNumber(req.getParameter("phoneNumber"))
                    .build();
            orderDetail.setCustomer((Customer) session.getAttribute("user"));
            Map<String,String> violations = ValidatorUtils.validate(orderDetail);
            if (!violations.isEmpty()){
                req.setAttribute("violations",violations);
                req.setAttribute("orderDetail",orderDetail);
                req.getRequestDispatcher("/WEB-CONTENT/pages/web/checkout.jsp").forward(req,resp);
            }
            else {
                orderDetailService.createOrder(cartItems, orderDetail);
                session.removeAttribute("cart");
                resp.sendRedirect("/");
            }
        }
    }
}
