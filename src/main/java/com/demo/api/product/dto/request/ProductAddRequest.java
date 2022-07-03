package com.demo.api.product.dto.request;

import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotBlank;

@Data
public class ProductAddRequest {

    @NotBlank
    private String title;

    private String description;

    @NumberFormat
    private Double price;
}
