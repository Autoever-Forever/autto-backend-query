package com.autto.queryservice.product.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.autto.queryservice.common.response.CustomException;
import com.autto.queryservice.common.response.ErrorResponseStatus;
import com.autto.queryservice.product.entity.Product;
import com.autto.queryservice.product.dto.ProductDetailDto;
import com.autto.queryservice.product.dto.ProductInventoryDto;
import com.autto.queryservice.product.entity.Status;
import com.autto.queryservice.product.repository.ProductRepository;
import com.autto.queryservice.product.repository.SeatRepository;
import java.util.UUID;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    ProductRepository productRepository;
    SeatRepository seatRepository;
  
    public List<com.autto.queryservice.product.dto.Product> QueryProduct (Integer pageNum) {
        PageRequest pageRequest = PageRequest.of(pageNum, 5);
        Page<Product> productInfos = productRepository.findByStatus(Status.ACTIVE, pageRequest);


        List<com.autto.queryservice.product.dto.Product> products = new ArrayList<>();
        for (Product productInfo: productInfos) {
            com.autto.queryservice.product.dto.Product product = new com.autto.queryservice.product.dto.Product(
                    productInfo.getId().toString(),
                    productInfo.getTitle(),
                    productInfo.getPosterUrl()
            );
            products.add(product);
        }
        return products;
    }

    public ProductService(ProductRepository productRepository, SeatRepository seatRepository) {
        this.productRepository = productRepository;
        this.seatRepository = seatRepository;
    }

    // 상품 상세 정보
    public ProductDetailDto QueryProductDetail(String id) {
        UUID uuid = UUID.fromString(id);

        if(!productRepository.existsById(uuid)) {
            throw new CustomException(ErrorResponseStatus.NOT_FOUND_PRODUCT_ID);
        }

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

        List<ProductInventoryDto> seatInfo = seatRepository.findSeatInfos(uuid);

        return seatInfo;
    }
}
