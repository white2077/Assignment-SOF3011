package com.sof3011.assignment.services;

import com.sof3011.assignment.entities.User;

public interface IUserService{
    public User authenticate(String username, String password);
    public User getUserByUsername(String username);
    }
