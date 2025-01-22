package com.autto.queryservice.product.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import com.autto.queryservice.product.entity.ProductInfo;
import com.autto.queryservice.product.entity.Status;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductInfo, UUID>, ProductDslRepository, QuerydslPredicateExecutor<ProductInfo> {
    Page<ProductInfo> findByStatus(Status status, Pageable pageable);
}