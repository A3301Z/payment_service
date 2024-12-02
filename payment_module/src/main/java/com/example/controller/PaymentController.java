package com.example.controller;

import com.example.api.PaymentApi;
import com.example.client.ProductServiceClient;
import com.example.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.example.dto.ProductDto;
import org.example.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PaymentController implements PaymentApi {

    private final ProductServiceClient productServiceClient;
    private final PaymentService paymentService;

    public ResponseEntity<List<ProductDto>> getProductsForUser(long userId) {
        try {
            return ResponseEntity.ok(productServiceClient.getProductsByUserId(userId));
        } catch (NotFoundException e) {
            throw new NotFoundException("Пользователь с ");
        }
    }

    public ResponseEntity<String> processPayment(UUID productId, long price) {
        try {
            paymentService.processPayment(productId, price);
            return ResponseEntity.ok("Платеж выполнен успешно");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ошибка при обработке платежа: недостаточно средств");
        }
    }
}