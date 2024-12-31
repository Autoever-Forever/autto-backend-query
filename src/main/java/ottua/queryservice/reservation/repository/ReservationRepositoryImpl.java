package ottua.queryservice.reservation.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import ottua.queryservice.reservation.dto.MyReservationDto;
import static ottua.queryservice.reservation.entity.QUserReservation.userReservation;
import ottua.queryservice.reservation.dto.*;

import java.util.List;
import java.util.UUID;

public class ReservationRepositoryImpl implements ReservationDslRepository{
    private final JPAQueryFactory queryFactory;

    public ReservationRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<MyReservationDto> findReservationByUserId(UUID userId) {
        return queryFactory
                .select(new QMyReservationDto(userReservation))
                .from(userReservation)
                .where(userReservation.user_id.eq(userId))
                .fetch();
    }
}
