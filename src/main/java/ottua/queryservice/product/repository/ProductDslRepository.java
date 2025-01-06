package ottua.queryservice.product.repository;


import ottua.queryservice.product.dto.ProductDetailDto;
import ottua.queryservice.product.entity.ProductInfo;

import java.util.List;
import java.util.UUID;

public interface ProductDslRepository {
    // product_id 값으로 seateInfo 테이블에서 price 값 가져오기
    ProductDetailDto findDetailProduct(UUID id);
}
