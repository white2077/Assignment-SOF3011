package com.sof3011.assignment.services.impl;

import com.sof3011.assignment.entities.Product;
import com.sof3011.assignment.exception.EntityNotFoundGeneralException;
import com.sof3011.assignment.repositories.IProductRepository;
import com.sof3011.assignment.services.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
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
    public Product getById(Long aLong) {
        return null;
    }

    @Override
    public void update(Long id, Product e) {
        if (repository.existsById(id)) {
            e.setModifiedDate(Timestamp.valueOf(LocalDateTime.now()));
            e.setId(id);
            repository.save(e);
        } else {
            throw new EntityNotFoundGeneralException("entity " + e.getClass() + " not found");
        }
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
}
