package ottua.queryservice.reservation.repository;

import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import ottua.queryservice.reservation.dto.MyReservationDto;
import static ottua.queryservice.reservation.entity.QUserReservation.userReservation;
import static ottua.queryservice.product.entity.QProductInfo.productInfo;
import static ottua.queryservice.product.entity.QSeatInfo.seatInfo;
import ottua.queryservice.reservation.dto.*;

import java.util.List;
import java.util.UUID;

public class ReservationRepositoryImpl implements ReservationDslRepository{
    private final JPAQueryFactory queryFactory;

    public ReservationRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<MyReservationDto> findByUserId(UUID userId) {
        return queryFactory
                .select(new QMyReservationDto(userReservation,
                        JPAExpressions.select(productInfo.title)
                                .from(productInfo)
                                .where(productInfo.id.eq(userReservation.productId))))
                .from(userReservation)
                .where(userReservation.userId.eq(userId))
                .fetch();
    }

    @Override
    public List<MyReservationDto> findReservationByUserId(UUID userId) {
        return queryFactory
                .select(new QMyReservationDto(userReservation, productInfo.title))
                .from(userReservation)
                .where(userReservation.userId.eq(userId))
                .leftJoin(productInfo).on(productInfo.id.eq(userReservation.productId))
                .fetch();
    }


}
