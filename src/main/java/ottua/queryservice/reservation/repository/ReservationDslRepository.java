package ottua.queryservice.reservation.repository;

import ottua.queryservice.reservation.dto.MyReservationDto;

import java.util.List;
import java.util.UUID;

public interface ReservationDslRepository {
    List<MyReservationDto> findByUserId(UUID userId);
    List<MyReservationDto> findReservationByUserId(UUID userId);
}
