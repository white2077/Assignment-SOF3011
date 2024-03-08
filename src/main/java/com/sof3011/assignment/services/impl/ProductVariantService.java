package com.sof3011.assignment.services.impl;

import com.sof3011.assignment.entities.ProductVariant;
import com.sof3011.assignment.repositories.IProductVariantRepository;
import com.sof3011.assignment.services.IProductVariantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductVariantService implements IProductVariantService {
    private final IProductVariantRepository iProductVariantRepository;
    @Override
    public List<ProductVariant> getAll() {
        return iProductVariantRepository.findAll();
    }

    @Override
    public ProductVariant insert(ProductVariant e) {
        return iProductVariantRepository.save(e);
    }

    @Override
    public void update(ProductVariant e) {
        e.setModifiedDate(Timestamp.valueOf(LocalDateTime.now()));
        iProductVariantRepository.save(e);
    }

    @Override
    public void delete(Long id) {
        iProductVariantRepository.deleteById(id);
    }
}
