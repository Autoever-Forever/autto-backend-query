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
    @Column(name = "running_time")
    private String runningTime;
    @Column(name = "ticketing_limit")
    private Integer ticketingLimit;
    @Column(name = "ticketing_open_date")
    private LocalDateTime ticketingOpenDate;
    @Column(name = "ticketing_close_date")
    private LocalDateTime ticketingCloseDate;
    @Column(name = "perform_start_date")
    private LocalDateTime performStartDate;
    @Column(name = "perform_end_date")
    private LocalDateTime performEndDate;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
    @Column(name = "thumbnail_url")
    private String thumbnailUrl;
    @Column(name = "poster_url")
    private String posterUrl;

    @Enumerated(EnumType.STRING)
    private Status status;
}
