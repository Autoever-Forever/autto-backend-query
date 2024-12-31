package ottua.queryservice.product.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
public class SeatInfo {

    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID id;

    private UUID productId;

    private Date date;

    private Integer reservedSeats;

    private Integer totalSeats;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private ProductInfo productInfo;

    // Status enum 정의
    public enum Status {
        ACTIVE, INACTIVE
    }
}
