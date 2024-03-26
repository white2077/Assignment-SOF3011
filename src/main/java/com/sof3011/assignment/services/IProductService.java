package com.sof3011.assignment.services;

import com.sof3011.assignment.entities.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface IProductService extends IServiceInterface<Product,Long> {
    List<Product> getAllProductFromPage(Pageable pageable);
    int getAllProductPage(Pageable pageable);
    Product getBySlug(String slug);
    List<Product> getTop8NewestProduct();
    Map<String,Long> getProductVariantMinMaxPriceByProduct(Product product);

}
