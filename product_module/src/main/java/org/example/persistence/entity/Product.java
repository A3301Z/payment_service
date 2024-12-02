package org.example.persistence.entity;


import lombok.Builder;
import lombok.Data;
import org.example.enumerations.ProductType;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@Builder
@Table(name = "products")
public class Product {

    @Id
    private UUID id;

    @Column("user_id")
    private long userId;

    @Column("account_number")
    private String accountNumber;

    @Column("balance")
    private long balance;

    @Column("product_type")
    private ProductType productType;
}
