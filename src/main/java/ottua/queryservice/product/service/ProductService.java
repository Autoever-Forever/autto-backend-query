package ottua.queryservice.product.service;

import org.springframework.stereotype.Service;
import ottua.queryservice.product.dto.ProductDetailDto;
import ottua.queryservice.product.dto.ProductInventoryDto;
import ottua.queryservice.product.entity.ProductInfo;
import ottua.queryservice.product.entity.SeatInfo;
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
    // uuid 변환 함수
    public static UUID convertToUUID(String hexUUID) {
        // "0x" 접두사 제거
        String hex = hexUUID.replace("0x", "");

        // MySQL BINARY(16)에서 표준 UUID 형식으로 변환
        StringBuilder sb = new StringBuilder(hex);
        sb.insert(8, '-');
        sb.insert(13, '-');
        sb.insert(18, '-');
        sb.insert(23, '-');

        System.out.println(sb);
        return UUID.fromString(sb.toString());
    }

    // 상품 상제 정보
    public List<ProductDetailDto> QueryProductDetail(String id) {

        UUID uuid = convertToUUID(id);

        List<ProductDetailDto> productDetailDto = productRepository.findDetailProduct(uuid);
        return productDetailDto;
    }


    // 날짜 및 재고 정보
    public List<ProductInventoryDto> QueryProductInventory(String id) {
        UUID uuid = convertToUUID(id);
        List<SeatInfo> seatInfo = seatRepository.findSeatInfosByProductInfoId(uuid);
        List<ProductInventoryDto> productInventories = new ArrayList<>();

        // status 로 예약 가능 여부 확인
        for (SeatInfo seat : seatInfo) {
            if (seat.getStatus().equals("active")) {
                ProductInventoryDto productInventoryDto = new ProductInventoryDto(
                        seat.getDate(),
                        seat.getTotalSeats() - seat.getReservedSeats()
                );
                productInventories.add(productInventoryDto);
            }
        }
        return productInventories;
    }
}
