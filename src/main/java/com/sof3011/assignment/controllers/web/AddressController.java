package com.sof3011.assignment.controllers.web;

import com.sof3011.assignment.entities.Address;
import com.sof3011.assignment.security.CustomPrincipal;
import com.sof3011.assignment.services.IAddressService;
import com.sof3011.assignment.services.IUserService;
import com.sof3011.assignment.services.impl.AddressService;
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
import java.util.Map;

@WebServlet(value = {"/address",
        "/address/add-page",
        "/address/add-address",
        "/address/edit-page",
        "/address/delete",
        "/address/set-default","/address/edit"})
public class AddressController extends HttpServlet {
    private final IAddressService addressService = ContextUtil.getBean(AddressService.class);
    private final IUserService iUserService = ContextUtil.getBean(UserService.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        HttpSession session = req.getSession();
        CustomPrincipal customPrincipal = (CustomPrincipal) session.getAttribute("user");
        if (uri.equals("/address")) {
            req.setAttribute("address", iUserService.getUserByUsername(customPrincipal.getName()).getAddresses());
            req.getRequestDispatcher("/WEB-CONTENT/pages/web/address.jsp").forward(req, resp);
        }
        else if (uri.equals("/address/add-page")) {
            req.getRequestDispatcher("/WEB-CONTENT/pages/web/address-form.jsp").forward(req, resp);
        }
        else if (uri.equals("/address/edit-page")) {
            req.setAttribute("address", addressService.getById(Long.parseLong(req.getParameter("id"))));
            req.getRequestDispatcher("/WEB-CONTENT/pages/web/address-form-update.jsp").forward(req, resp);
        }
        else if (uri.equals("/address/delete")) {
            addressService.deleteByUser(iUserService.getUserByUsername(customPrincipal.getName()), Long.parseLong(req.getParameter("id")));
            resp.sendRedirect("/address");
        } else if (uri.equals("/address/set-default")) {
            addressService.setDefaultAddress(iUserService.getUserByUsername(customPrincipal.getName()), Long.parseLong(req.getParameter("id")));
            resp.sendRedirect("/address");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("/add-address")){
            HttpSession session = req.getSession();
            CustomPrincipal customPrincipal = (CustomPrincipal) session.getAttribute("user");
            Address address = Address
                    .builder()
                    .address(req.getParameter("address"))
                    .cityOrProvince(req.getParameter("cityOrProvince"))
                    .district(req.getParameter("district"))
                    .customer(iUserService.getUserByUsername(customPrincipal.getName()))
                    .build();
            Map<String, String> violations = ValidatorUtils.validate(address);
            if (!violations.isEmpty()) {
                req.setAttribute("violations", violations);
                req.getRequestDispatcher("/WEB-CONTENT/pages/web/address-form.jsp").forward(req, resp);
            }
            else {
                addressService.insert(address);
                resp.sendRedirect("/address");
            }
        }
        else if(uri.equals("/address/edit")){
            Address address = addressService.getById(Long.parseLong(req.getParameter("id")));
            address.setAddress(req.getParameter("address"));
            address.setCityOrProvince(req.getParameter("cityOrProvince"));
            address.setDistrict(req.getParameter("district"));
            Map<String, String> violations = ValidatorUtils.validate(address);
            if (!violations.isEmpty()) {
                req.setAttribute("violations", violations);
                req.setAttribute("address", address);
                req.getRequestDispatcher("/WEB-CONTENT/pages/web/address-form-update.jsp").forward(req, resp);
            }
            else {
                addressService.update(address);
                resp.sendRedirect("/address");
            }
        }
    }
}
