package com.autto.queryservice.product.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.UuidGenerator;
import java.time.LocalDateTime;

import java.util.UUID;

@Entity
@Getter
@Table(name="product")
public class Product {
    @Id
    @UuidGenerator
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    private String title;

    private String location;

    private String runningTime;

    private Integer ticketingLimit;

    private Byte ageLimit;

    private LocalDateTime ticketingOpenDate;

    private LocalDateTime ticketingCloseDate;

    private LocalDateTime performStartDate;

    private LocalDateTime performEndDate;

    private LocalDateTime createdDate;

    private LocalDateTime lastUpdate;

    private String thumbnailUrl;

    private String posterUrl;

    @Enumerated(EnumType.STRING)
    private Status status;
}
