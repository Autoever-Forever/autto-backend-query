package ottua.queryservice.product.service;

import org.springframework.stereotype.Service;
import ottua.queryservice.product.dto.ProductDetailDto;
import ottua.queryservice.product.dto.ProductInventoryDto;
import ottua.queryservice.product.entity.SeatInfo;
import ottua.queryservice.product.entity.Status;
import ottua.queryservice.product.repository.ProductRepository;
import ottua.queryservice.product.repository.SeatRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    ProductRepository productRepository;
    SeatRepository seatRepository;

    public ProductService(ProductRepository productRepository, SeatRepository seatRepository) {
        this.productRepository = productRepository;
        this.seatRepository = seatRepository;
    }

    // 상품 상제 정보
    public ProductDetailDto QueryProductDetail(String id) {
        UUID uuid = UUID.fromString(id);

        ProductDetailDto productDetailDto = productRepository.findDetailProduct(uuid);
        // 유효성 검사 - 안 쓸 듯?
        if (productDetailDto.getStatus() == Status.ACTIVE) {
            return productDetailDto;
        }
        else {return null;}
    }

    // 날짜 및 재고 정보
    public List<ProductInventoryDto>QueryProductInventory(String id) {
        UUID uuid = UUID.fromString(id);

        List<SeatInfo> seatInfo = seatRepository.findSeatInfosByProductInfoId(uuid);
        List<ProductInventoryDto> productInventories = new ArrayList<>();

        // status 로 예약 가능 여부 확인
        // 예약이 불가능하더라도 데이터는 보여주는 것이 맞는듯
        for (SeatInfo seat: seatInfo) {
            System.out.println(seat.getId());
            ProductInventoryDto inventory = new ProductInventoryDto(seat.getDate(),
                    seat.getTotalSeats() - seat.getReservedSeats());

            productInventories.add(inventory);
        }
        return productInventories;
    }
}
