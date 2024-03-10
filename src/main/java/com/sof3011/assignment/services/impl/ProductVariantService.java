package com.sof3011.assignment.services.impl;

import com.sof3011.assignment.entities.ProductVariant;
import com.sof3011.assignment.exception.EntityNotFoundGeneralException;
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
    public ProductVariant getById(Long aLong) {
        return null;
    }

    @Override
    public void update(Long id, ProductVariant e) {
        if (iProductVariantRepository.existsById(id)) {
            e.setModifiedDate(Timestamp.valueOf(LocalDateTime.now()));
            e.setId(id);
            iProductVariantRepository.save(e);
        } else {
            throw new EntityNotFoundGeneralException("entity " + e.getClass() + " not found");
        }
    }

    @Override
    public void delete(Long id) {
        iProductVariantRepository.deleteById(id);
    }
}
