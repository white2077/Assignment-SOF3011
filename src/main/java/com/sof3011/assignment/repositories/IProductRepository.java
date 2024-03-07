package com.sof3011.assignment.repositories;

import com.sof3011.assignment.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Long> {
}
