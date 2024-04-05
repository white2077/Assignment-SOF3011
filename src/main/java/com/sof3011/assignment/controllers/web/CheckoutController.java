package com.sof3011.assignment.controllers.web;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sof3011.assignment.entities.Address;
import com.sof3011.assignment.entities.Cart;
import com.sof3011.assignment.entities.User;
import com.sof3011.assignment.entities.OrderDetail;
import com.sof3011.assignment.security.CustomPrincipal;
import com.sof3011.assignment.services.ICartService;
import com.sof3011.assignment.services.ICookieService;
import com.sof3011.assignment.services.IOrderDetailService;
import com.sof3011.assignment.services.IProductVariantService;
import com.sof3011.assignment.services.IUserService;
import com.sof3011.assignment.services.impl.AddressService;
import com.sof3011.assignment.services.impl.CartService;
import com.sof3011.assignment.services.impl.CookieService;
import com.sof3011.assignment.services.impl.UserService;
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

@WebServlet(value = {"/checkout-page", "/checkout", "/checkout-cart", "/order-success"})
public class CheckoutController extends HttpServlet {
    private final IOrderDetailService orderDetailService = ContextUtil.getBean(IOrderDetailService.class);
    private final IProductVariantService productVariantService = ContextUtil.getBean(IProductVariantService.class);
    private final ICookieService cookieService = new CookieService();
    private final IUserService userService = ContextUtil.getBean(UserService.class);
    private final ICartService cartService = ContextUtil.getBean(CartService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        HttpSession session = req.getSession();
        if (uri.contains("/order-success")) {
            OrderDetail orderDetail = (OrderDetail) session.getAttribute("orderDetails");
            if (orderDetail != null) {
                req.setAttribute("order", orderDetail);
                session.removeAttribute("cart");
                session.removeAttribute("orderDetails");
                req.getRequestDispatcher("WEB-CONTENT/pages/web/order-complete.jsp").forward(req, resp);
            } else {
                resp.sendRedirect("/");
            }

        }else{
            if (session.getAttribute("cart") != null) {
                if (session.getAttribute("user") != null) {
                    CustomPrincipal customPrincipal = (CustomPrincipal)session.getAttribute("user") ;
                    User user = userService.getUserByUsername(customPrincipal.getName());
                    Address address = new Address();
                    address.setCustomer(new User());
                    address = user.getAddresses().stream().filter(Address::isDefaultAddress).findFirst().orElse(address);
                    req.setAttribute("customerName", address.getCustomer().getCustomerName());
                    req.setAttribute("phoneNumber", address.getCustomer().getPhoneNumber());
                    req.setAttribute("address", address.getAddress());
                    req.setAttribute("cityOrProvince", address.getCityOrProvince());
                    req.setAttribute("district", address.getDistrict());
                }
                req.getRequestDispatcher("/WEB-CONTENT/pages/web/checkout.jsp").forward(req, resp);
            } else {
                resp.sendRedirect("/");
            }
        }
}

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String uri = req.getRequestURI();
    HttpSession session = req.getSession();
    List<Cart> carts = new ArrayList<>();
    if (uri.contains("/checkout-cart")) {
        String cartCookie = cookieService.getCookie(req, "cart");
        if (session.getAttribute("user") == null) {
            String decoded = new String(Base64.getDecoder().decode(cartCookie));
            carts = new Gson().fromJson(decoded, new TypeToken<List<Cart>>() {
            }.getType());
        }
        else {
            carts = cartService.getCartByUser(userService.getUserByUsername(((CustomPrincipal) session.getAttribute("user")).getName()));
        }

        session.setAttribute("cart", carts);
        resp.sendRedirect("/checkout-page");
    } else if (uri.contains("/checkout-page")) {
        Cart cartItem = Cart
                .builder()
                .productVariant(productVariantService.getById(Long.valueOf(req.getParameter("productVariantId"))))
                .quantity(Integer.parseInt(req.getParameter("quantity")))
                .build();
        carts.add(cartItem);
        session.setAttribute("cart", carts);
        resp.sendRedirect("/checkout-page");
    } else if (uri.equals("/checkout")) {
        List<Cart> cartItems = (List<Cart>) session.getAttribute("cart");
        CustomPrincipal customPrincipal = (CustomPrincipal) session.getAttribute("user");
        OrderDetail orderDetail =  customPrincipal != null ?
        OrderDetail
                .builder().customerName(req.getParameter("customerName"))
                .address(req.getParameter("address"))
                .district(req.getParameter("district"))
                .customer(userService.getUserByUsername(customPrincipal.getName()))
                .cityOrProvince(req.getParameter("cityOrProvince"))
                .phoneNumber(req.getParameter("phoneNumber"))
                .build():
                OrderDetail
                        .builder().customerName(req.getParameter("customerName"))
                        .address(req.getParameter("address"))
                        .district(req.getParameter("district"))
                        .cityOrProvince(req.getParameter("cityOrProvince"))
                        .phoneNumber(req.getParameter("phoneNumber"))
                        .build();
        Map<String, String> violations = ValidatorUtils.validate(orderDetail);
        if (!violations.isEmpty()) {
            req.setAttribute("violations", violations);
            req.setAttribute("orderDetail", orderDetail);
            req.getRequestDispatcher("/WEB-CONTENT/pages/web/checkout.jsp").forward(req, resp);
        } else {
            session.setAttribute("orderDetails", orderDetailService.createOrder(cartItems, orderDetail));
            resp.sendRedirect("/order-success");
        }
    }
}
}
