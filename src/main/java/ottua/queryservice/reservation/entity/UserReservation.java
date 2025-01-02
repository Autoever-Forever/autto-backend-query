package ottua.queryservice.reservation.entity;

import jakarta.persistence.*;

import lombok.Getter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Table(name="user_reservation")
public class UserReservation {
    @Id
    @UuidGenerator
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(nullable = false)
    private LocalDateTime ticket_date;

    @Column(nullable = false)
    private LocalDateTime created_date;

    @Column(nullable = false)
    private LocalDateTime last_update;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(columnDefinition = "BINARY(16)", nullable = false)
    private UUID productId;

    @Column(columnDefinition = "BINARY(16)", nullable = false)
    private UUID userId;
}
