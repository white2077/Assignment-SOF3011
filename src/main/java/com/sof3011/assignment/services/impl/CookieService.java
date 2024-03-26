package com.sof3011.assignment.services.impl;

import com.sof3011.assignment.services.ICookieService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CookieService implements ICookieService {
    @Override
    public String getCookie(HttpServletRequest request, String name) {
        Cookie[] cookie =  request.getCookies();
        if(cookie != null){
            for (Cookie c : cookie){
                if(c.getName().equals(name)){
                    return c.getValue();
                }
            }
        }
        return null;
    }

    @Override
    public void setCookie(HttpServletResponse httpResponse, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name,value);
        cookie.setMaxAge(maxAge);
        cookie.setPath("/");
        httpResponse.addCookie(cookie);
    }

    @Override
    public void deleteCookie(HttpServletResponse response, String name) {
        Cookie cookie = new Cookie(name,"");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
