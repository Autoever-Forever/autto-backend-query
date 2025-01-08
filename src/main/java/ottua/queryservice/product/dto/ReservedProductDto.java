package ottua.queryservice.product.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservedProductDto {
    private String title;
    private LocalDateTime ticketDate;
    private String thumbnailUrl;

    @QueryProjection
    public ReservedProductDto(LocalDateTime ticketDate, String title, String thumbnailUrl) {
        this.title = title;
        this.ticketDate = ticketDate;
        this.thumbnailUrl = thumbnailUrl;
    }
}
