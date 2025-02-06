package com.autto.queryservice.product.dto;

import com.autto.queryservice.product.entity.Product;
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
    public ProductDetailDto(Product product, BigDecimal price) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.location = product.getLocation();
        this.performStartDate = product.getPerformStartDate();
        this.performEndDate = product.getPerformEndDate();
        this.runningTime = product.getRunningTime();
        this.price = price;
        this.ticketLimit = product.getTicketingLimit();
        this.posterUrl = product.getPosterUrl();
        this.status = product.getStatus();
    }
}
