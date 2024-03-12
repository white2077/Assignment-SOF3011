package com.sof3011.assignment.services.impl;

import com.sof3011.assignment.entities.OrderDetail;
import com.sof3011.assignment.services.IOrderDetaiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class OrderDetailService implements IOrderDetaiService {
    @Override
    public OrderDetail createOrder(List<Long> idOderItems) {
        return null;
    }

    @Override
    public List<OrderDetail> getAll() {
        return null;
    }

    @Override
    public OrderDetail getById(Long id) {
        return null;
    }

    @Override
    public OrderDetail insert(OrderDetail e) {
        return null;
    }

    @Override
    public void update(OrderDetail e) {

    }

    @Override
    public void delete(Long id) {

    }
}
