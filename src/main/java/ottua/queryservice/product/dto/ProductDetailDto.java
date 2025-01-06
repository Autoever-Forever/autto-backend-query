package ottua.queryservice.product.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import ottua.queryservice.product.entity.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
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
        this.id = productInfo.getId();
        this.title = productInfo.getTitle();
        this.location = productInfo.getLocation();
        this.performStartDate = productInfo.getPerformStartDate();
        this.performEndDate = productInfo.getPerformEndDate();
        this.runningTime = productInfo.getRunningTime();
        this.price = price;
        this.posterUrl = productInfo.getPosterUrl();
        this.status = productInfo.getStatus();
    }
}
