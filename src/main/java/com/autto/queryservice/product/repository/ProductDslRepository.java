package com.autto.queryservice.product.repository;


import com.autto.queryservice.product.dto.ProductDetailDto;

import java.util.UUID;

public interface ProductDslRepository {
    // product_id 값으로 seateInfo 테이블에서 price 값 가져오기
    ProductDetailDto findDetailProduct(UUID id);
}
