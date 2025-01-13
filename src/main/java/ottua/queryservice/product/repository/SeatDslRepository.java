package ottua.queryservice.product.repository;

import ottua.queryservice.product.dto.ProductInventoryDto;
import ottua.queryservice.product.dto.ReservedProductDetailDto;
import ottua.queryservice.product.dto.ReservedProductDto;

import java.util.List;
import java.util.UUID;

public interface SeatDslRepository {
    List<ProductInventoryDto> findSeatInfos (UUID productID);
    ReservedProductDto findSeatBySeatId(UUID seatId);
    ReservedProductDetailDto findProductDetailBySeatId(UUID seatId);
}
