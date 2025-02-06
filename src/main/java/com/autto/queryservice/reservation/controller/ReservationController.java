package com.autto.queryservice.reservation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autto.queryservice.common.UuidFormatter;
import com.autto.queryservice.common.response.BaseApiResponse;
import com.autto.queryservice.reservation.service.ReservationService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products/mypage/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    @GetMapping("/")
    public BaseApiResponse<?> getMyReservationList(@AuthenticationPrincipal User user) throws IllegalArgumentException, Exception {
        String userId = UuidFormatter.replaceUuid(user.getUsername());
        return BaseApiResponse.success("예약 내역 조회 성공", reservationService.requestReservationList(userId));
    }

    @GetMapping("/cancel/{reservationId}")
    public BaseApiResponse<?> getMyReservationDetail(@PathVariable String reservationId) throws IllegalArgumentException, Exception {
        return BaseApiResponse.success("예약 취소 상세페이지 조회 성공", reservationService.requestReservationDetail(reservationId));
    }
}
