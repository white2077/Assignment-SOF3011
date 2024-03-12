package com.sof3011.assignment.repositories;

import com.sof3011.assignment.entities.Product;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IProductRepository extends JpaRepository<Product,Long> {
    public Optional<Product> findBySlug(String slug);
}
