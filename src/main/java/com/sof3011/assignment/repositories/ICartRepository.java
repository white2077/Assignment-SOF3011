package com.sof3011.assignment.repositories;

import com.sof3011.assignment.entities.Cart;
import com.sof3011.assignment.entities.ProductVariant;
import com.sof3011.assignment.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICartRepository extends JpaRepository<Cart, Long>{
    List<Cart> findCartByCustomer(User customer);
}
