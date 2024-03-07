package com.sof3011.assignment.services;

import java.util.List;

public interface IService <T,K>{
    List<T> getAll();
    T insert(T e);
    void update(T e);
    void delete(K id);
}
