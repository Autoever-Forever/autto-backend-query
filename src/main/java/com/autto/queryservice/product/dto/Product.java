package com.autto.queryservice.product.dto;

// dto
// 상품 전체 조회
import lombok.Data;
import lombok.Getter;
import java.time.LocalDateTime;

@Data
@Getter
public class Product {

    private String id;
    private String title;
    private String posterUrl;
    private String location;
    private LocalDateTime performStartDate;
    private LocalDateTime performEndDate;

    public Product(String id, String title, String posterUrl, String location, LocalDateTime performStartDate, LocalDateTime performEndDate) {
        this.id = id;
        this.title = title;
        this.posterUrl = posterUrl;
        this.location = location;
        this.performStartDate = performStartDate;
        this.performEndDate = performEndDate;
    }
}
