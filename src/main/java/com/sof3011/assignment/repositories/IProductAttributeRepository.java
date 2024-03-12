package com.sof3011.assignment.repositories;

import com.sof3011.assignment.entities.ProductAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductAttributeRepository extends JpaRepository<ProductAttribute,Long> {
    List<ProductAttribute> findAllByAttributeParentAndAttributeType(ProductAttribute attributeParent, boolean attributeType);
    @Query("SELECT a.slug from product_attributes a where a.attributeParent = null and a.attributeType=true")
    List<String> findAllSlugForProductAttribute();
    @Query("SELECT a.slug from product_attributes a where a.attributeParent = null and a.attributeType=false")
    List<String> findAllSlugForProductVariantAttribute();
}
