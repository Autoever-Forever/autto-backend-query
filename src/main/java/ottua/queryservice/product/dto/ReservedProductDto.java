package ottua.queryservice.product.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservedProductDto {
    private String title;
    private LocalDateTime ticketDate;

    @QueryProjection
    public ReservedProductDto(LocalDateTime ticketDate, String title) {
        this.title = title;
        this.ticketDate = ticketDate;
    }
}
