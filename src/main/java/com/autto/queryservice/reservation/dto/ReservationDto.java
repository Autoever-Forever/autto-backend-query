package com.autto.queryservice.reservation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
@Getter
public class ReservationDto {
    @JsonProperty("reservationId")
    private String reservationId;
    @JsonProperty("seatId")
    private String seatId;
    @JsonProperty("createdDate")
    private LocalDateTime createdDate;
    @JsonProperty("status")
    private String status;
}
