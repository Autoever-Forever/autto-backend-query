package ottua.queryservice.product.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
public class ProductInfo {

    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID id;

    private String title;

    private String location;

    private String runningTime;

    private Integer ticketingLimit;

    private Byte ageLimit;

    private Date ticketingOpenDate;

    private Date ticketingCloseDate;

    private Date performStartDate;

    private Date performEndDate;

    private Date createdDate;

    private Date lastUpdate;

    private String thumbnailUrl;

    private String posterUrl;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        ACTIVE, INACTIVE
    }
}
