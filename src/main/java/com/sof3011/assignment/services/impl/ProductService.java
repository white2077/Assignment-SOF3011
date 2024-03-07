package com.sof3011.assignment.services.impl;

import com.sof3011.assignment.entities.Product;
import com.sof3011.assignment.repositories.IProductRepository;
import com.sof3011.assignment.services.IService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductService implements IService<Product,Long> {
    private final IProductRepository iProductRepository;
    @Override
    public List<Product> getAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Product insert(Product e) {
        return iProductRepository.save(e);
    }

    @Override
    public void update(Product e) {
        iProductRepository.save(e);
    }

    @Override
    public void delete(Long id) {
        iProductRepository.deleteById(id);
    }
}
