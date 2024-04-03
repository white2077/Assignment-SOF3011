package com.sof3011.assignment.controllers.auth;

import com.sof3011.assignment.security.AuthRequestWrapper;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebFilter(urlPatterns = "/admin/*", filterName = "AdminFilter")
public class AdminFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        AuthRequestWrapper request = (AuthRequestWrapper) servletRequest;
        HttpServletResponse response  = (HttpServletResponse) servletResponse;

        if (! request.isUserInRole("ADMIN")) {
            request.getRequestDispatcher("/page/error/access-denied.jsp").forward(request, response);
            return;
        }
        filterChain.doFilter(request, response);
    }
}
