package com.sof3011.assignment.services.impl;

import com.sof3011.assignment.entities.Cart;
import com.sof3011.assignment.entities.OrderDetail;
import com.sof3011.assignment.entities.OrderItem;
import com.sof3011.assignment.entities.User;
import com.sof3011.assignment.enums.OrderStatus;
import com.sof3011.assignment.repositories.IOrderDetailRepository;
import com.sof3011.assignment.repositories.IOrderItemRepository;
import com.sof3011.assignment.services.IOrderDetailService;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderDetailService implements IOrderDetailService {
    private final IOrderDetailRepository orderDetailRepository;
    private final IOrderItemRepository orderItemRepository;
    @Override
    public OrderDetail createOrder(List<Cart> cartItems, OrderDetail orderDetail) {
        List<OrderItem> orderItems =cartItems.stream().map(cart -> OrderItem
                .builder()
                .note("")
                .quantity(cart.getQuantity())
                .price(cart.getProductVariant().getPrice())
                .productVariant(cart.getProductVariant())
                .build()).collect(Collectors.toList());
        orderDetail.setTotal(orderItems.stream().mapToLong(value -> value.getPrice() * value.getQuantity()).sum());
        orderDetail.setStatus(OrderStatus.PENDING);
        OrderDetail order = orderDetailRepository.save(orderDetail);
        orderItems.forEach(orderItem -> orderItem.setOrderDetail(order));
        orderItemRepository.saveAll(orderItems);
        return orderDetailRepository.findById(order.getId()).orElse(null);
    }

    @Override
    public void updateStatus(Long id, OrderStatus orderStatus) {
        OrderDetail orderDetail = orderDetailRepository.findById(id).orElseThrow(() -> new NoResultException("Order not found"));
        orderDetail.setModifiedDate(Timestamp.valueOf(LocalDateTime.now()));
        orderDetail.setStatus(orderStatus);
        orderDetailRepository.save(orderDetail);

    }

    @Override
    public List<OrderDetail> getbyCustomer(User user) {
        return orderDetailRepository.findAllByCustomer(user);
    }

    @Override
    public OrderDetail getById(Long id) {
        return orderDetailRepository.findById(id).orElse(null);
    }

    @Override
    public List<OrderDetail> getAll() {
        return orderDetailRepository.findAll();
    }
}
