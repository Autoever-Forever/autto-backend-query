package ottua.queryservice.product.repository;


import ottua.queryservice.product.entity.ProductInfo;

import java.util.List;

public interface ProductDslRepository {
    public List<ProductInfo> findAllProducts();
}
