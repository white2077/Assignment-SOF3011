package com.sof3011.assignment.services.impl;

import com.sof3011.assignment.entities.Product;
import com.sof3011.assignment.repositories.IProductRepository;
import com.sof3011.assignment.services.IProductService;
import com.sof3011.assignment.services.IService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private final IProductRepository repository;
    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public Product getById(Long id) {
        return null;
    }

    @Override
    public Product insert(Product e) {
        return repository.save(e);
    }

    @Override
    public void update(Product e) {
        e.setModifiedDate(Timestamp.valueOf(LocalDateTime.now()));
        repository.save(e);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Product> getAllProductFromPage(Pageable pageable) {
        return null;
    }

    @Override
    public int getAllProductPage(Pageable pageable) {
        return 0;
    }

    @Override
    public Product getBySlug(String slug) {
        return repository.findBySlug(slug).orElseThrow(() -> new NoSuchElementException("not found"));
    }
}
