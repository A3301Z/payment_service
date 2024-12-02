package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.ProductDto;
import org.example.exception.NotFoundException;
import org.example.persistence.repository.ProductRepository;
import org.example.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductDto findById(UUID id) {
        return productRepository.findById(id).map(ProductDto::toProductDto)
                .orElseThrow(() -> new NotFoundException(String.format("Продукт не найден id = %s", id)));
    }

    @Override
    public List<ProductDto> findAllByUserId(long userId) {
        return Optional.ofNullable(productRepository.findAllByUserId(userId))
                .filter(products -> !products.isEmpty())
                .orElseThrow(() -> new NotFoundException(String.format("Пользователь не найден userId  = %s", userId)))
                .stream()
                .map(ProductDto::toProductDto)
                .toList();
    }
}


