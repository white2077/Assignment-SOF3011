package com.sof3011.assignment.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface ICookieService {
    public String getCookie(HttpServletRequest request, String name);
    public void setCookie(HttpServletResponse httpResponse, String name, String value, int maxAge);
    public void deleteCookie(HttpServletResponse response, String name);
}
