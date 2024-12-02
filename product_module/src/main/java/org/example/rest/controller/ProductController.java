package org.example.rest.controller;

import lombok.RequiredArgsConstructor;
import org.example.rest.api.ProductApi;
import org.example.dto.ProductDto;
import org.example.service.ProductService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ProductController implements ProductApi {

    private final ProductService productService;

    public ProductDto findById(UUID id) {
        return productService.findById(id);
    }

    public List<ProductDto> findAllByUserId(long userId) {
        return productService.findAllByUserId(userId);
    }
}
