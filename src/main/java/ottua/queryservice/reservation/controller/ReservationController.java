package ottua.queryservice.reservation.controller;

import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ottua.queryservice.common.UuidFormatter;
import ottua.queryservice.common.response.CustomException;
import ottua.queryservice.common.response.BaseApiResponse;
import ottua.queryservice.reservation.service.ReservationService;

@RestController
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @GetMapping("/mypage/reservation")
    public BaseApiResponse<?> getMyReservationList(@AuthenticationPrincipal User user) throws IllegalArgumentException, Exception {
        String userId = UuidFormatter.replaceUuid(user.getUsername());
        return BaseApiResponse.success("예약 내역 조회 성공", reservationService.requestReservationList(userId));
    }

    @GetMapping("/mypage/reservation/cancel/{reservationId}")
    public BaseApiResponse<?> getMyReservationDetail(@PathVariable String reservationId) throws IllegalArgumentException, Exception {
        return BaseApiResponse.success("예약 취소 상세페이지 조회 성공", reservationService.requestReservationDetail(reservationId));
    }
}
