package org.example.persistence.repository;

import org.example.persistence.entity.Product;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends CrudRepository<Product, UUID> {

    @Query("select * from products where id = :id")
    Optional<Product> findById(UUID id);

    @Query("select * from products where user_id = :userId")
    List<Product> findAllByUserId(long userId);
}
