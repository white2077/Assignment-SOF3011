package com.sof3011.assignment.services.impl;

import com.sof3011.assignment.services.ISessionService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class SessionService implements ISessionService {
    @Override
    public void set(HttpServletRequest request, String key, Object value) {
       HttpSession session = request.getSession();
       session.setAttribute(key, value);
    }

    @Override
    public Object get(HttpServletRequest request, String key) {
        HttpSession session = request.getSession();
        return session.getAttribute(key);
    }

    @Override
    public void remove(HttpServletRequest request, String key) {
        HttpSession session = request.getSession();
        session.removeAttribute(key);
    }

    @Override
    public void clear(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
    }
}
