package ottua.queryservice.reservation.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import ottua.queryservice.product.entity.ProductInfo;
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
    private String title;

    @QueryProjection
    public MyReservationDto(UserReservation userReservation, String title) {
        this.reservation_id = userReservation.getId();
        this.product_id = userReservation.getProductId();
        this.created_date = userReservation.getCreated_date();
        this.updated_date = userReservation.getLast_update();
        this.ticket_date = userReservation.getTicket_date();
        this.status = userReservation.getStatus().name();
        this.title = title;
    }
}
