package ottua.queryservice.product.service;

import org.springframework.stereotype.Service;
import ottua.queryservice.product.dto.ProductDetail;
import ottua.queryservice.product.dto.ProductInventory;
import ottua.queryservice.product.entity.ProductInfo;
import ottua.queryservice.product.entity.SeatInfo;
import ottua.queryservice.product.repository.ProductRepository;
import ottua.queryservice.product.repository.SeatInfoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    ProductRepository productRepository;
    SeatInfoRepository seatInfoRepository;

    public ProductService(ProductRepository productRepository, SeatInfoRepository seatInfoRepository) {
        this.productRepository = productRepository;
        this.seatInfoRepository = seatInfoRepository;
    }

    // 상품 상제 정보
    public ProductDetail QueryProductDetail(UUID id) {

        Optional<ProductInfo> productDetailInfo = productRepository.findById(id);
        ProductDetail productDetail = new ProductDetail(
                productDetailInfo.get().getId(),
                productDetailInfo.get().getTitle(),
                productDetailInfo.get().getLocation(),
                productDetailInfo.get().getPerformStartDate(),
                productDetailInfo.get().getPerformEndDate(),
                productDetailInfo.get().getRunningTime(),
                productDetailInfo.get().getPosterUrl(),
                productDetailInfo.get().getStatus()

       );

        if (productDetailInfo.get().getStatus().equals("ACTIVE")) {
            return productDetail;
        } else {
            return null;
        }
    }

    // 날짜 및 재고 정보
    public List<ProductInventory> QueryProductInventory (UUID id) {
        List<SeatInfo> seatInfo = seatInfoRepository.findByProductInfo(id);
        List<ProductInventory> productInventories = new ArrayList<>();

        // status 로 예약 가능 여부 확인
        for (SeatInfo seat: seatInfo) {
            if (seat.getStatus().equals("active")) {
                ProductInventory productInventory = new ProductInventory(
                        seat.getDate(),
                        seat.getTotalSeats() - seat.getReservedSeats()
                );
                productInventories.add(productInventory);
            }
        }
        return productInventories;


    }
}
