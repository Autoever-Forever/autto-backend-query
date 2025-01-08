package ottua.queryservice.product.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import ottua.queryservice.product.dto.QReservedProductDto;
import ottua.queryservice.product.dto.ReservedProductDto;

import static ottua.queryservice.product.entity.QProductInfo.productInfo;
import static ottua.queryservice.product.entity.QSeatInfo.seatInfo;

import java.util.UUID;

public class SeatRepositoryImpl implements SeatDslRepository {
    private final JPAQueryFactory queryFactory;

    public SeatRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public ReservedProductDto findSeatBySeatId(UUID seatId) {
        return queryFactory
                .select(new QReservedProductDto(seatInfo.date, productInfo.title, productInfo.thumbnailUrl))
                .from(seatInfo)
                .where(seatInfo.id.eq(seatId))
                .leftJoin(productInfo).on(seatInfo.productInfo.id.eq(productInfo.id))
                .fetchOne();
    }
}
