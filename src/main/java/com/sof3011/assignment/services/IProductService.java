package com.sof3011.assignment.services;

import com.sof3011.assignment.entities.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService extends IService<Product,Long>{
    List<Product> getAllProductFromPage(Pageable pageable);
    int getAllProductPage(Pageable pageable);
}
