package com.sof3011.assignment.services;

import jakarta.servlet.http.HttpServletRequest;

public interface ISessionService {
    void set(HttpServletRequest request, String key, Object value);
    Object get(HttpServletRequest request,String key);
    void remove(HttpServletRequest request,String key);
    void clear(HttpServletRequest request);
}
