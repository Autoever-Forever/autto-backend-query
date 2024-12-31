package ottua.queryservice.reservation.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ottua.queryservice.reservation.dto.MyReservationDto;
import ottua.queryservice.reservation.repository.ReservationRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public List<MyReservationDto> getReservation(UUID id){
        return reservationRepository.findReservationByUserId(id);
    }

}
