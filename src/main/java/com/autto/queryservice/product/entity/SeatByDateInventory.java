package com.autto.queryservice.product.entity;

import ch.qos.logback.core.util.Loader;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Table(name="seat_by_date_inventory")
public class SeatByDateInventory {
    @Id
    @UuidGenerator
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @ManyToOne
    @JoinColumn(name="product_id", referencedColumnName="id")
    private Product product;

    private LocalDateTime date;
    @Column(name = "reserved_seats")
    private Integer reservedSeats;
    @Column(name = "total_seats")
    private Integer totalSeats;

    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "currency_code")
    private String currencyCode;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @Enumerated(EnumType.STRING)
    private Status status;
}
