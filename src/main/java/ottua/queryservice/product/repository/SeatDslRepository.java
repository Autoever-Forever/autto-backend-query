package ottua.queryservice.product.repository;

import ottua.queryservice.product.dto.ReservedProductDto;

import java.util.UUID;

public interface SeatDslRepository {
    ReservedProductDto findSeatBySeatId(UUID seatId);
}
