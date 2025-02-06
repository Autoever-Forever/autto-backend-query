package com.autto.queryservice.product.repository;

import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import com.autto.queryservice.product.dto.ProductDetailDto;
import com.autto.queryservice.product.dto.QProductDetailDto;
import java.util.UUID;


import static com.autto.queryservice.product.entity.QProduct.product;
import static com.autto.queryservice.product.entity.QSeatByDateInventory.seatByDateInventory;

public class ProductRepositoryImpl implements ProductDslRepository {
    private final JPAQueryFactory queryFactory;


    public ProductRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    // product_id 값으로 seateInfo 테이블에서 price 값 가져오기
    public ProductDetailDto findDetailProduct(UUID id) {
        return queryFactory
                .select(new QProductDetailDto(product,
                        JPAExpressions
                                .select(seatByDateInventory.price.min())
                                .from(seatByDateInventory)
                                .where(seatByDateInventory.product.id.eq(product.id))
                ))
                .from(product)
                .where(product.id.eq(id))
                .fetchOne();
    }
}
