package ottua.queryservice.product.repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import ottua.queryservice.product.entity.ProductInfo;
import ottua.queryservice.product.entity.Status;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductInfo, UUID>, ProductDslRepository, QuerydslPredicateExecutor<ProductInfo> {
    Page<ProductInfo> findByStatus(Status status, Pageable pageable);
}
