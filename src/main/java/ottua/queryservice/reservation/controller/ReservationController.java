package ottua.queryservice.reservation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ottua.queryservice.common.UuidFormatter;
import ottua.queryservice.common.response.BaseApiResponse;
import ottua.queryservice.reservation.dto.MyReservationDto;
import ottua.queryservice.reservation.service.ReservationService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @GetMapping("/mypage/reservation")
    public BaseApiResponse<List<MyReservationDto>> getMyReservationList(@AuthenticationPrincipal User user) {
        String userId = UuidFormatter.replaceUuid(user.getUsername());
        return new BaseApiResponse<>(HttpStatus.OK.value(), "예약 내역 조회 성공", reservationService.requestReservationList(userId));
    }
}
