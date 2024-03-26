package com.sof3011.assignment.services;

import com.sof3011.assignment.entities.OrderDetail;

import java.util.List;

public interface IOrderDetaiService extends IServiceInterface<OrderDetail,Long> {
    OrderDetail createOrder(List<Long> idOderItems);
}
