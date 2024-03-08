package com.sof3011.assignment.services.impl;

import com.sof3011.assignment.entities.ProductAttribute;
import com.sof3011.assignment.services.IProductAttributeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductAttributeService implements IProductAttributeService {
    @Override
    public List<ProductAttribute> getAll() {
        return null;
    }

    @Override
    public ProductAttribute insert(ProductAttribute e) {
        return null;
    }

    @Override
    public void update(ProductAttribute e) {

    }

    @Override
    public void delete(Long id) {

    }
}
