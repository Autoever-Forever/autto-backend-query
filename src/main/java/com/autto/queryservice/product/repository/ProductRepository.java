package com.autto.queryservice.product.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import com.autto.queryservice.product.entity.Product;
import com.autto.queryservice.product.entity.Status;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID>, ProductDslRepository, QuerydslPredicateExecutor<Product> {
    Page<Product> findByStatus(Status status, Pageable pageable);
}