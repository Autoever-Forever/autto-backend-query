package ottua.queryservice.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import ottua.queryservice.product.entity.ProductInfo;

import java.awt.print.Pageable;
import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductInfo, UUID>, ProductDslRepository, QuerydslPredicateExecutor<ProductInfo> {
    List<ProductInfo> findAllBy(Pageable pageable);
}
