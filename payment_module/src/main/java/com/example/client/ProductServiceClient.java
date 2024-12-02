package com.example.client;

import lombok.RequiredArgsConstructor;
import org.example.dto.ProductDto;
import org.example.exception.NotFoundException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceClient {

    private final RestClient restClient;

    public ProductDto getProductById(UUID productId) {

        ProductDto product = restClient.get()
                .uri(uriBuilder -> uriBuilder.path("/findById").queryParam("id", productId).build())
                .retrieve()
                .body(ProductDto.class);

        if (product == null) {
            throw new NotFoundException(String.format("Продукт не найден productId = %s", productId));
        }

        return product;
    }

    public List<ProductDto> getProductsByUserId(long userId) {

        ResponseEntity<List<ProductDto>> response = restClient.get()
                .uri(uriBuilder -> uriBuilder.path("/findAllByUserId")
                        .queryParam("userId", userId)
                        .build())
                .retrieve()
                .toEntity(new ParameterizedTypeReference<>() {
                });

        return response.getBody();
    }
}
