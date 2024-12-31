package ottua.queryservice.product.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Table(name="seat_info")
public class SeatInfo {
    @Id
    @UuidGenerator
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @ManyToOne
    @JoinColumn(name="product_id", referencedColumnName="id")
    private ProductInfo productInfo;

    private LocalDateTime date;

    private Integer reservedSeats;

    private Integer totalSeats;

    @Enumerated(EnumType.STRING)
    private Status status;
}
