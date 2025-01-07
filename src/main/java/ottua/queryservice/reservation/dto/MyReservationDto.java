package ottua.queryservice.reservation.dto;

import lombok.Data;
import ottua.queryservice.product.dto.ReservedProductDto;

import java.time.LocalDateTime;

@Data
public class MyReservationDto {
    private String reservationId;
    private String seatId;
    private LocalDateTime createdDate;
    private LocalDateTime ticketDate;
    private String status;
    private String title;

    public MyReservationDto(ReservationDto reservation, ReservedProductDto reservedProduct) {
        this.reservationId = reservation.getReservationId();
        this.seatId = reservation.getSeatId();
        this.createdDate = reservation.getCreatedDate();
        this.status = reservation.getStatus();
        this.ticketDate = reservedProduct.getTicketDate();
        this.title = reservedProduct.getTitle();
    }
}

