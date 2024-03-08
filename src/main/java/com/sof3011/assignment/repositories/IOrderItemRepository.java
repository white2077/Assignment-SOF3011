package com.sof3011.assignment.repositories;

import com.sof3011.assignment.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderItemRepository extends JpaRepository<OrderItem,Long> {
}
