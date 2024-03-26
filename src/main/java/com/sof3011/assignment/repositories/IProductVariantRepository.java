package com.sof3011.assignment.repositories;

import com.sof3011.assignment.entities.Product;
import com.sof3011.assignment.entities.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Map;
import java.util.Optional;

public interface IProductVariantRepository extends JpaRepository<ProductVariant,Long> {
    @Query("SELECT new map(MIN(pv.price) as minPrice, MAX(pv.price) as maxPrice)  FROM product_variants pv WHERE pv.product = :product")
    Optional<Map<String, Long>> findMinMaxPricesByProduct(@Param("product") Product product);
}
