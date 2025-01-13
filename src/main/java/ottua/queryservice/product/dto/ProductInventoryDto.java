package ottua.queryservice.product.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import ottua.queryservice.product.entity.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ProductInventoryDto {

    private UUID seatId;
    private String title;
    private String location;
    private LocalDateTime performStartDate;
    private LocalDateTime performEndDate;
    private LocalDateTime date;
    private Integer inventory;
    private BigDecimal price;
    private Status status;

    @QueryProjection
    public ProductInventoryDto(UUID seatId, String title, String location, LocalDateTime performStartDate, LocalDateTime performEndDate, LocalDateTime date, Integer inventory, BigDecimal price, Status status) {
        this.seatId = seatId;
        this.title = title;
        this.location = location;
        this.performStartDate = performStartDate;
        this.performEndDate = performEndDate;
        this.date = date;
        this.inventory = inventory;
        this.price = price;
        this.status = status;
    }

}
