package ottua.queryservice.reservation.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import ottua.queryservice.product.dto.ReservedProductDto;
import ottua.queryservice.product.repository.SeatRepository;
import ottua.queryservice.reservation.dto.MyReservationDto;
import ottua.queryservice.reservation.dto.ReservationResponseDto;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final RestTemplate restTemplate;
    private final SeatRepository seatRepository;

    public List<MyReservationDto> requestReservationList(String user_id) {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090/api/v1/reservation")
                .path("/list/{id}")
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
}
