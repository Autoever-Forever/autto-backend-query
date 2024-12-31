package ottua.queryservice.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import ottua.queryservice.reservation.entity.UserReservation;

import java.util.UUID;

@Repository
public interface ReservationRepository extends JpaRepository<UserReservation, UUID>, ReservationDslRepository, QuerydslPredicateExecutor<UserReservation> {

}
