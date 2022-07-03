package com.demo.api.product.controller;

import com.demo.api.product.dto.response.ProductResponse;
import com.demo.api.product.services.impl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    private static final String ENDPOINT = "/api/v1/products";
    private static final int totalOfRecords = 10;
    private static final int pageSize = 5;

    private MockMvc mockMvc;

    @Mock
    private ProductServiceImpl productService;


    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new ProductController(productService)).build();
    }

    @Test
    void getAll_Successfully() throws Exception {
        final int page = 0;
        when(this.productService.getAll(any())).thenReturn(mockPageResponse(page));

        MvcResult mvcResult = this.mockMvc
                .perform(get(ENDPOINT))
                .andDo(print()) //log
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalElements").value(totalOfRecords))
                .andExpect(jsonPath("$.totalPages").value(totalOfRecords /pageSize))
                .andExpect(jsonPath("$.content.length()").value(pageSize))
                .andReturn();
        assertEquals(MediaType.APPLICATION_JSON_VALUE, mvcResult.getResponse().getContentType());
    }

    private Page<ProductResponse> mockPageResponse(int page) {
        List<ProductResponse> productResponses = new ArrayList<>();
        for (int i = 0; i < pageSize; i++) {
            productResponses.add(mockResponse(i));
        }
        return new PageImpl<>(productResponses, PageRequest.of(page, pageSize, Sort.unsorted()), totalOfRecords);
    }

    private ProductResponse mockResponse(long id) {
        return  ProductResponse.builder().id(1l)
                .title("Iphone 1").description("This is Iphone 1")
                .price(1.2)
                .build();
    }
}
