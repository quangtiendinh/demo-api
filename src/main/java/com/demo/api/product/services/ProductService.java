package com.demo.api.product.services;

import com.demo.api.product.dto.filter.ProductFilter;
import com.demo.api.product.dto.response.ProductResponse;
import com.demo.api.product.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    Page<ProductResponse> getAll(ProductFilter productFilter);

    Product getById(long id);

    Product add(Product product);

    Product update(long id, Product product);

    void delete(long id);
}
