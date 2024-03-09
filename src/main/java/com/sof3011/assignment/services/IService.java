package com.sof3011.assignment.services;

import java.util.List;

public interface IService<T, ID> {
    List<T> getAll();

    T getById(ID id);

    T insert(T e);

    void update(ID id, T e);

    void delete(ID id);
}
