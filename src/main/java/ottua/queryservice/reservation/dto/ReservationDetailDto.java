package ottua.queryservice.reservation.dto;

import jakarta.persistence.Column;
import lombok.Data;
import ottua.queryservice.product.dto.ReservedProductDetailDto;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDateTime;

@Data
public class ReservationDetailDto {
    private String reservationId;
    private String title;
    private String posterUrl;
    private LocalDateTime ticketDate;
    private String location;
    private String price;
    private Integer seatCount;
    private String seatsPrice;
    private String status;

    public ReservationDetailDto(String reservationId, ReservationCancelDto reservationCancelDto, ReservedProductDetailDto reservedProductDetailDto) {
        this.reservationId = reservationId;
        this.title = reservedProductDetailDto.getTitle();
        this.posterUrl = reservedProductDetailDto.getPosterUrl();
        this.ticketDate = reservedProductDetailDto.getTicketDate();
        this.location = reservedProductDetailDto.getLocation();
        this.seatCount = reservationCancelDto.getSeatCount();
        this.status = reservationCancelDto.getStatus();

        DecimalFormat priceKRWFormat  = new DecimalFormat("#,###.##");
        this.price = priceKRWFormat.format(reservedProductDetailDto.getPrice()) + "원";
        this.seatsPrice = priceKRWFormat.format(reservedProductDetailDto.getPrice().multiply(BigDecimal.valueOf(seatCount))) + "원";
    }
}
