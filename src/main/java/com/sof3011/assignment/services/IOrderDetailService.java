package com.sof3011.assignment.services;

import com.sof3011.assignment.entities.Cart;
import com.sof3011.assignment.entities.OrderDetail;

import java.util.List;

public interface IOrderDetailService extends IServiceInterface<OrderDetail,Long> {
    OrderDetail createOrder(List<Cart> cartItems, OrderDetail orderDetail);
}
