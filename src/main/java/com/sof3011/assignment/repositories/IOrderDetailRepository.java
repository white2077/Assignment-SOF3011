package com.sof3011.assignment.repositories;

import com.sof3011.assignment.entities.OrderDetail;
import com.sof3011.assignment.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOrderDetailRepository extends JpaRepository<OrderDetail,Long> {
    List<OrderDetail> findAllByCustomer(User customer);
}
