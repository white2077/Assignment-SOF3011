package com.sof3011.assignment.repositories;

import com.sof3011.assignment.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IProductRepository extends JpaRepository<Product,Long> {
     Optional<Product> findBySlug(String slug);
     List<Product> findTop5ByStatusIsTrueOrderByCreatedDateDesc();
}
