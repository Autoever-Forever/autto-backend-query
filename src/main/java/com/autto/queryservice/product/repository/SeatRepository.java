package com.autto.queryservice.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import com.autto.queryservice.product.entity.ProductInfo;
import com.autto.queryservice.product.entity.SeatInfo;

import java.util.UUID;

@Repository
public interface SeatRepository extends JpaRepository<SeatInfo, UUID>, SeatDslRepository, QuerydslPredicateExecutor<ProductInfo> {
}
