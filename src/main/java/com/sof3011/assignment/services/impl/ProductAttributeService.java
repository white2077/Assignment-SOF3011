package com.sof3011.assignment.services.impl;

import com.sof3011.assignment.entities.ProductAttribute;
import com.sof3011.assignment.repositories.IProductAttributeRepository;
import com.sof3011.assignment.services.IProductAttributeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ProductAttributeService implements IProductAttributeService {
    private final IProductAttributeRepository productAttributeRepository;
    @Override
    public List<ProductAttribute> getAll() {
        return productAttributeRepository.findAll();
    }

    @Override
    public ProductAttribute getById(Long id) {
        return productAttributeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("not found"));
    }

    @Override
    public ProductAttribute insert(ProductAttribute e) {
        return productAttributeRepository.save(e);
    }

    @Override
    public void update(ProductAttribute e) {
        productAttributeRepository.save(e);
    }

    @Override
    public void delete(Long id) {
        productAttributeRepository.deleteById(id);
    }

    @Override
    public List<ProductAttribute> getAllParentAttributeProduct() {
        return productAttributeRepository.findAllByAttributeParentAndAttributeType(null,true);
    }

    @Override
    public List<ProductAttribute> getAllParentAttributeProductVariant() {
        return productAttributeRepository.findAllByAttributeParentAndAttributeType(null,false);
    }

    @Override
    public List<String> getAllProductAttributeSlug() {
        return productAttributeRepository.findAllSlugForProductAttributeAndProductVariant(true);
    }

    @Override
    public Set<ProductAttribute> getAllProductAttributeByIds(Set<Long> id) {
        return new HashSet<>(productAttributeRepository.findAllById(id));
    }

    @Override
    public ProductAttribute getCategory() {
        return productAttributeRepository.findCategory();
    }

}
