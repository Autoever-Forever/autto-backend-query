package ottua.queryservice.product.dto;

import java.time.LocalDateTime;

public class ProductInventoryDto {

    private LocalDateTime date;
    private Integer inventroy;

    public ProductInventoryDto(LocalDateTime date, Integer inventroy) {
        this.date = date;
        this.inventroy = inventroy;
    }

}
