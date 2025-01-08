package ottua.queryservice.product.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Getter
public class ReservedProductDetailDto {
    private String title;
    private String posterUrl;
    private LocalDateTime ticketDate;
    private String location;
    private BigDecimal price;

    @QueryProjection
    public ReservedProductDetailDto(String title, String posterUrl, String location, LocalDateTime ticketDate, BigDecimal price) {
        this.title = title;
        this.posterUrl = posterUrl;
        this.location = location;
        this.ticketDate = ticketDate;
        this.price = price;
    }
}
