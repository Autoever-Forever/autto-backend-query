package com.autto.queryservice.product.repository;

import com.autto.queryservice.product.dto.ProductInventoryDto;
import com.autto.queryservice.product.dto.ReservedProductDetailDto;
import com.autto.queryservice.product.dto.ReservedProductDto;

import java.util.List;
import java.util.UUID;

public interface SeatDslRepository {
    List<ProductInventoryDto> findSeatInfos (UUID productID);
    ReservedProductDto findSeatBySeatId(UUID seatId);
    ReservedProductDetailDto findProductDetailBySeatId(UUID seatId);
}
