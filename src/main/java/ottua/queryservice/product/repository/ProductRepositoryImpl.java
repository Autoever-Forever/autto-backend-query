package ottua.queryservice.product.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import ottua.queryservice.product.entity.ProductInfo;

import java.util.List;

public class ProductRepositoryImpl implements ProductDslRepository {
    private final JPAQueryFactory queryFactory;

    public ProductRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<ProductInfo> findAllProducts() {
        return List.of();
    }
}
