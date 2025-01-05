package ottua.queryservice.product.dto;

import com.querydsl.core.annotations.QueryProjection;
import ottua.queryservice.product.entity.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class ProductDetailDto {

    private UUID id;
    private String posterUrl;
    private String title;
    private String location;
    private LocalDateTime performStartDate;
    private LocalDateTime performEndDate;
    private String runningTime;
    private BigDecimal price;
    private Status status;

    @QueryProjection
    public ProductDetailDto(ProductInfo productInfo, BigDecimal price) {
        id = productInfo.getId();
        title = productInfo.getTitle();
        location = productInfo.getLocation();
        performStartDate = productInfo.getPerformStartDate();
        performEndDate = productInfo.getPerformEndDate();
        runningTime = productInfo.getRunningTime();
        price = price;
        posterUrl = productInfo.getPosterUrl();
        status = productInfo.getStatus();
    }
}
