package ottua.queryservice.product.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import ottua.queryservice.product.dto.*;

import static ottua.queryservice.product.entity.QProductInfo.productInfo;
import static ottua.queryservice.product.entity.QSeatInfo.seatInfo;

import java.util.List;
import java.util.UUID;

public class SeatRepositoryImpl implements SeatDslRepository {
    private final JPAQueryFactory queryFactory;

    public SeatRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<ProductInventoryDto> findSeatInfos(UUID productID) {
        return (List<ProductInventoryDto>) queryFactory
                .select(new QProductInventoryDto(seatInfo.id, productInfo.title, productInfo.location, productInfo.performStartDate, productInfo.performEndDate, seatInfo.date, seatInfo.totalSeats.subtract(seatInfo.reservedSeats),seatInfo.price, seatInfo.status))
                .from(seatInfo)
                .where(seatInfo.productInfo.id.eq(productID))
                .leftJoin(productInfo).on(seatInfo.productInfo.id.eq(productInfo.id))
                .fetch();
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

    @Override
    public ReservedProductDetailDto findProductDetailBySeatId(UUID seatId) {
        return queryFactory
                .select(new QReservedProductDetailDto(productInfo.title, productInfo.posterUrl, productInfo.location, seatInfo.date, seatInfo.price))
                .from(seatInfo)
                .where(seatInfo.id.eq(seatId))
                .leftJoin(productInfo).on(seatInfo.productInfo.id.eq(productInfo.id))
                .fetchOne();
    }
}
