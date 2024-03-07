package com.sof3011.assignment.services;

import com.sof3011.assignment.entities.OrderDetail;

import java.util.List;

public interface IOrderDetaiService extends IService<OrderDetail,Long>{
    void createOrders(List<Long> idOderItems);
}
