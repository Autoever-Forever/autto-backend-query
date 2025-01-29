package com.autto.queryservice.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import com.autto.queryservice.product.entity.Product;
import com.autto.queryservice.product.entity.SeatByDateInventory;

import java.util.UUID;

@Repository
public interface SeatRepository extends JpaRepository<SeatByDateInventory, UUID>, SeatDslRepository, QuerydslPredicateExecutor<Product> {
}
