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
    private final IProductRepository repository;
    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public Product insert(Product e) {
        return repository.save(e);
    }

    @Override
    public void update(Product e) {
        repository.save(e);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
