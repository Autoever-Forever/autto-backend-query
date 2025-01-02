package ottua.queryservice.product.dto;

import ottua.queryservice.product.entity.Status;

import java.time.LocalDateTime;

public class ProductInventory {

    private LocalDateTime date;
    private Integer inventroy;
//    private Status status;

    public ProductInventory (LocalDateTime date, Integer inventroy) {
        this.date = date;
        this.inventroy = inventroy;
//        this.status = status;
    }

}
