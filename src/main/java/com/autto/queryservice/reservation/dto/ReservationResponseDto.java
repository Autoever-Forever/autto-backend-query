package com.autto.queryservice.reservation.dto;

import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Getter
public class ReservationResponseDto {
    private int status;
    private String message;
    private String error;
    private List<ReservationDto> data;
}
