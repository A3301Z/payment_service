package com.example.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.dto.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Tag(name = "API оплаты")
@RequestMapping("/api/v1/payments")
public interface PaymentApi {

    @Operation(summary = "Получить список продуктов пользователя")
    @GetMapping("/products")
    ResponseEntity<List<ProductDto>> getProductsForUser(@RequestParam long userId);

    @Operation(summary = "Провести оплату")
    @GetMapping("/pay")
    ResponseEntity<String> processPayment(@RequestParam UUID productId,
                                          @RequestParam long price);
}