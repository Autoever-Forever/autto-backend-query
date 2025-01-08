package ottua.queryservice.reservation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ottua.queryservice.common.response.BaseApiResponse;
import ottua.queryservice.reservation.dto.MyReservationDto;
import ottua.queryservice.reservation.service.ReservationService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @GetMapping("/mypage/reservation/{id}")
    public BaseApiResponse<List<MyReservationDto>> getMyReservationList(@PathVariable UUID id) {
        return new BaseApiResponse<>(HttpStatus.OK.value(), "예약 내역 조회 성공", reservationService.requestReservationList(id));
    }
}
