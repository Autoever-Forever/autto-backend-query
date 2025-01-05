package ottua.queryservice.product.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Table(name="product_info")
public class ProductInfo {
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
