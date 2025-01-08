package ottua.queryservice.reservation.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ottua.queryservice.product.repository.ProductRepository;
import ottua.queryservice.reservation.dto.MyReservationDto;
import ottua.queryservice.reservation.dto.ReservationResponseDto;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final RestTemplate restTemplate;
    private final ProductRepository productRepository;

    public List<MyReservationDto> requestReservationList(UUID user_id) {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/reservations/{id}")
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
                    String title = productRepository.findById(reservation.getProductId()).get().getTitle();
                    return new MyReservationDto(reservation, title);
                })
                .collect(Collectors.toList());
    }
}
