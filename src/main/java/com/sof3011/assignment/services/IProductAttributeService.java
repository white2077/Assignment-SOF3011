package com.sof3011.assignment.services;

import com.sof3011.assignment.entities.ProductAttribute;

import java.util.List;
import java.util.Set;

public interface IProductAttributeService extends IService<ProductAttribute,Long> {
    List<ProductAttribute> getAllParentAttributeProduct();
    List<ProductAttribute> getAllParentAttributeProductVariant();
    List<String> getAllProductAttributeSlug();
    List<ProductAttribute> getAllProductAttributeByIds(Set<Long> id);
    ProductAttribute getCategory();

}
