package com.demo.api.product.services;

import com.demo.api.product.dto.filter.ProductFilter;
import com.demo.api.product.dto.request.ProductAddRequest;
import com.demo.api.product.dto.request.ProductUpdateRequest;
import com.demo.api.product.dto.response.ProductResponse;
import com.demo.api.product.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    Page<ProductResponse> getAll(ProductFilter productFilter);

    ProductResponse getById(long id);

    ProductResponse add(ProductAddRequest request);

    ProductResponse update(long id, ProductUpdateRequest request);

    void delete(long id);
}
