package com.example.service;

import com.example.client.ProductServiceClient;
import com.example.exception.InsufficientFundsException;
import lombok.RequiredArgsConstructor;
import org.example.dto.ProductDto;
import org.example.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final ProductServiceClient productServiceClient;

    public void processPayment(UUID productId, long price) {

        ProductDto product = productServiceClient.getProductById(productId);

        if (product == null) {
            throw new NotFoundException(String.format("Продукт не найден productId = %s", productId));
        }

        if (product.balance < price) {
            throw new InsufficientFundsException("Недостаточно средств на счету");
        }
    }
}
