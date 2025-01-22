package com.autto.queryservice.product.dto;

import com.autto.queryservice.product.entity.ProductInfo;
import com.autto.queryservice.product.entity.Status;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Data
public class ProductDetailDto {

    private UUID id;
    private String posterUrl;
    private String title;
    private String location;
    private LocalDateTime performStartDate;
    private LocalDateTime performEndDate;
    private String runningTime;
    private BigDecimal price;
    private Integer ticketLimit;
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
        this.ticketLimit = productInfo.getTicketingLimit();
        this.posterUrl = productInfo.getPosterUrl();
        this.status = productInfo.getStatus();
    }
}
