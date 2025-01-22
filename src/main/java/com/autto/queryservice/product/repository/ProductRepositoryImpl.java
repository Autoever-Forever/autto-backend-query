package com.autto.queryservice.product.repository;

import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import com.autto.queryservice.product.dto.ProductDetailDto;
import com.autto.queryservice.product.dto.QProductDetailDto;
import java.util.UUID;


import static com.autto.queryservice.product.entity.QProductInfo.productInfo;
import static com.autto.queryservice.product.entity.QSeatInfo.seatInfo;

public class ProductRepositoryImpl implements ProductDslRepository {
    private final JPAQueryFactory queryFactory;


    public ProductRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    // product_id 값으로 seateInfo 테이블에서 price 값 가져오기
    public ProductDetailDto findDetailProduct(UUID id) {
        return queryFactory
                .select(new QProductDetailDto(productInfo,
                        JPAExpressions
                                .select(seatInfo.price.min())
                                .from(seatInfo)
                                .where(seatInfo.productInfo.id.eq(productInfo.id))
                ))
                .from(productInfo)
                .where(productInfo.id.eq(id))
                .fetchOne();
    }
}
