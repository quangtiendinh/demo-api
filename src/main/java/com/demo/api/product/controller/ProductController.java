package com.demo.api.product.controller;

import com.demo.api.product.dto.filter.ProductFilter;
import com.demo.api.product.dto.request.ProductAddRequest;
import com.demo.api.product.dto.request.ProductUpdateRequest;
import com.demo.api.product.dto.response.ProductResponse;
import com.demo.api.product.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<Page<ProductResponse>> getAll(ProductFilter productFilter) {
        return ResponseEntity.ok(this.productService.getAll(productFilter));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getById(@PathVariable long id) {
        return ResponseEntity.ok(this.productService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable long id, @RequestBody ProductUpdateRequest request) {
        return ResponseEntity.ok(this.productService.update(id, request));
    }

    @PostMapping
    public ResponseEntity<ProductResponse> add(@RequestBody ProductAddRequest request) {
        return ResponseEntity.ok(this.productService.add(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable long id) {
        this.productService.delete(id);
        return ResponseEntity.ok().build();
    }
}
