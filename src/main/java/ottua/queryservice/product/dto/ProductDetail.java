package ottua.queryservice.product.dto;

import ottua.queryservice.product.entity.Status;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public class ProductDetail {

    private UUID id;
    private String title;
    private String location;
    private LocalDateTime performStartDate;
    private LocalDateTime performEndDate;
    private String runningTime;
    private String posterUrl;
    private Status status;

    public ProductDetail (UUID id, String title, String location, LocalDateTime performStartDate, LocalDateTime performEndDate, String runningTime, String posterUrl, Status status ){
        this.id = id;
        this.title = title;
        this.location = location;
        this.performStartDate = performStartDate;
        this.performEndDate = performEndDate;
        this.runningTime = runningTime;
        this.posterUrl = posterUrl;
        this.status = status;
    }

}
