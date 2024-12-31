package ottua.queryservice.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import ottua.queryservice.product.entity.ProductInfo;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductInfo, UUID>, ProductDslRepository, QuerydslPredicateExecutor<ProductInfo> {
}
