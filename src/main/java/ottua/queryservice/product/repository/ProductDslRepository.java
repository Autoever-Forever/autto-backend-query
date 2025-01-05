package ottua.queryservice.product.repository;


import ottua.queryservice.product.dto.ProductDetailDto;
import ottua.queryservice.product.entity.ProductInfo;
import ottua.queryservice.product.entity.SeatInfo;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface ProductDslRepository {
    public List<ProductInfo> findAllProducts();

    public List<ProductDetailDto> findDetailProduct(UUID id);
}
