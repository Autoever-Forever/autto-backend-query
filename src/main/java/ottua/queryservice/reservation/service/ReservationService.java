package ottua.queryservice.reservation.service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponse;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import ottua.queryservice.common.response.CustomException;
import ottua.queryservice.common.response.ErrorResponseStatus;
import ottua.queryservice.config.CustomConfig;
import ottua.queryservice.product.dto.ReservedProductDetailDto;
import ottua.queryservice.product.dto.ReservedProductDto;
import ottua.queryservice.product.repository.SeatRepository;
import ottua.queryservice.reservation.dto.*;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final CustomConfig customConfig;
    private final RestTemplate restTemplate;
    private final SeatRepository seatRepository;

    public List<MyReservationDto> requestReservationList(String user_id) {
        URI uri = UriComponentsBuilder
                .fromUriString(customConfig.getReservationUrl())
                .path("/list/{user_id}")
                .encode()
                .build()
                .expand(user_id)
                .toUri();

        ReservationResponseDto response = restTemplate.getForObject(uri, ReservationResponseDto.class);

        if(response.getData().isEmpty()) {
            return Collections.emptyList();
        }

        return response.getData().stream()
                .map(reservation -> {
                    UUID seatId = UUID.fromString(reservation.getSeatId());
                    ReservedProductDto reservedProduct = seatRepository.findSeatBySeatId(seatId);
                    return new MyReservationDto(reservation, reservedProduct);
                })
                .collect(Collectors.toList());
    }


    public ReservationDetailDto requestReservationDetail(String reservation_id) {
        URI uri = UriComponentsBuilder
                .fromUriString(customConfig.getReservationUrl())
                .path("/cancel/{reservation_id}")
                .encode()
                .build()
                .expand(reservation_id)
                .toUri();

        ReservationCancelResponseDto response = restTemplate.getForObject(uri, ReservationCancelResponseDto.class);

        UUID seatId = UUID.fromString(response.getData().getSeatId());
        ReservedProductDetailDto reservedProductDetail = seatRepository.findProductDetailBySeatId(seatId);

        if(reservedProductDetail.getTitle().isEmpty()){
            throw new CustomException(ErrorResponseStatus.NOT_FOUND_SEAT_ID);
        }

        return new ReservationDetailDto(reservation_id, response.getData(), reservedProductDetail);
    }
}
