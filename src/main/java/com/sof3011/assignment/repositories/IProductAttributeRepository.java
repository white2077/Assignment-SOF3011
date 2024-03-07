package com.sof3011.assignment.repositories;

import com.sof3011.assignment.entities.ProductAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductAttributeRepository extends JpaRepository<ProductAttribute,Long> {

}
