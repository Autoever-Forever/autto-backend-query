package com.autto.queryservice.reservation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class ReservationCancelDto {
    @JsonProperty("seatId")
    private String seatId;
    @JsonProperty("seatCount")
    private int seatCount;
    @JsonProperty("reservationStatus")
    private String status;
}
