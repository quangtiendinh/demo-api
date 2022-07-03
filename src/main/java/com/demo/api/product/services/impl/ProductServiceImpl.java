package com.demo.api.product.services.impl;

import com.demo.api.core.expections.NotFoundResourceException;
import com.demo.api.core.utils.BeanUtil;
import com.demo.api.product.dto.filter.ProductFilter;
import com.demo.api.product.dto.response.ProductResponse;
import com.demo.api.product.entity.Product;
import com.demo.api.product.payload.ProductRepository;
import com.demo.api.product.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
@CacheConfig(cacheNames = "productCache")
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Cacheable(cacheNames = "products", key = "#productFilter")
    @Override
    public Page<ProductResponse> getAll(ProductFilter productFilter) {
        this.waitSomeTime();
        Pageable pageable = PageRequest.of(productFilter.getPage(), productFilter.getLimit());
        return this.productRepository.findAll(pageable)
                .map(item -> BeanUtil.copyProperties(item, ProductResponse.class));
    }

    @Cacheable(cacheNames = "product", key = "#id", unless = "#result == null")
    @Override
    public Product getById(long id) {
        return this.productRepository.findById(id)
                .orElseThrow(() -> new NotFoundResourceException("The product is not found with id ["+ id +"]"));
    }

    @Override
    public Product add(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public Product update(long id, Product request) {
        Product product = this.productRepository.findById(id)
                .orElseThrow(() -> new NotFoundResourceException("The product is not found with id ["+ id +"]"));
        product.setTitle(request.getTitle());
        product.setPrice(request.getPrice());
        product.setDescription(request.getDescription());
        product.setDescription(request.getDescription());
        product.setDescription(request.getDescription());
        return this.productRepository.save(product);
    }

    @Override
    public void delete(long id) {
        this.productRepository.deleteById(id);
    }

    public void waitSomeTime() {
        System.out.println("Start database access...");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End database access...");
    }
}
