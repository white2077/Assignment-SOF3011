package com.sof3011.assignment.repositories;

import com.sof3011.assignment.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderDetailRepository extends JpaRepository<OrderDetail,Long> {
}
