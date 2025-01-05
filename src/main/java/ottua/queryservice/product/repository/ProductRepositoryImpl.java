package ottua.queryservice.product.repository;

import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import ottua.queryservice.product.dto.ProductDetailDto;
import ottua.queryservice.product.dto.QProductDetailDto;
import ottua.queryservice.product.entity.ProductInfo;
import ottua.queryservice.product.entity.SeatInfo;

import java.util.List;
import java.util.UUID;

import static ottua.queryservice.product.entity.QProductInfo.productInfo;
import static ottua.queryservice.product.entity.QSeatInfo.seatInfo;

public class ProductRepositoryImpl implements ProductDslRepository {
    private final JPAQueryFactory queryFactory;


    public ProductRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<ProductInfo> findAllProducts() {
        return List.of();
    }

    @Override
    // product_id 값으로 seateInfo 테이블에서 price 값 가져오기
    public List<ProductDetailDto> findDetailProduct(UUID id) {

        return queryFactory
                .select(new QProductDetailDto(productInfo,
                        JPAExpressions
                                .select(seatInfo.price)
                                .from(seatInfo)
                                .where(seatInfo.productInfo.id.eq(productInfo.id))
                ))
                .from(productInfo)
                .where(productInfo.id.eq(id))
                .fetch();
//
//                queryFactory
//                .select(new QProductDetailDto(productInfo, seatInfo.price))
//                .from(productInfo)
//                .where(productInfo.id.eq(id))
//                .leftJoin(seatInfo).on(seatInfo.productInfo.id.eq(productInfo.id))
//                .fetch();



    }



}
