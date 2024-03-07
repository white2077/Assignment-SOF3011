package com.sof3011.assignment.repositories;

import com.sof3011.assignment.entities.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductVariantRepository extends JpaRepository<ProductVariant,Long> {
}
