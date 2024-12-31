package ottua.queryservice.reservation.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import ottua.queryservice.reservation.entity.UserReservation;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class MyReservationDto {
    private UUID reservation_id;
    private UUID product_id;
    private LocalDateTime created_date;
    private LocalDateTime updated_date;
    private LocalDateTime ticket_date;
    private String status;

    @QueryProjection
    public MyReservationDto(UserReservation userReservation) {
        reservation_id = userReservation.getId();
        product_id = userReservation.getProduct_id();
        created_date = userReservation.getCreated_date();
        updated_date = userReservation.getLast_update();
        ticket_date = userReservation.getTicket_date();
        status = userReservation.getStatus().name();
    }
}
