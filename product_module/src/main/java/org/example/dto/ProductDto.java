package org.example.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import org.example.enumerations.ProductType;
import org.example.persistence.entity.Product;

import java.util.UUID;

@Builder
@Schema(description = "Dto продукта")
public class ProductDto {

    @Schema(description = "Идентификатор продукта", example = "414b5efb-ad31-4a11-8cbc-23379015aa36")
    public UUID id;

    @Schema(description = "Идентификатор пользователя", example = "1")
    public long userId;

    @Schema(description = "Номер (код) аккаунта пользователя", example = "account_001")
    public String accountNumber;

    @Schema(description = "Баланс", example = "1500")
    public long balance;

    @Schema(description = "Тип продукта", example = "(ACCOUNT || CARD)")
    public ProductType productType;

    public static ProductDto toProductDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .userId(product.getUserId())
                .accountNumber(product.getAccountNumber())
                .balance(product.getBalance())
                .productType(product.getProductType())
                .build();
    }
}
