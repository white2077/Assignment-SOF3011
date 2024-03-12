package com.sof3011.assignment.repositories;

import com.sof3011.assignment.entities.ProductAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductAttributeRepository extends JpaRepository<ProductAttribute,Long> {
    List<ProductAttribute> findAllByAttributeParentAndAttributeType(ProductAttribute attributeParent, boolean attributeType);
    @Query("SELECT a.slug from product_attributes a where a.attributeParent = null and a.attributeType=:type")
    List<String> findAllSlugForProductAttributeAndProductVariant(@Param("type") boolean type);
    @Query("SELECT a from product_attributes a where  a.attributeType=null and a.attributeParent=null")
    ProductAttribute findCategory();
}
