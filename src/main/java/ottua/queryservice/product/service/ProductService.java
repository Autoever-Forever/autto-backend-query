package ottua.queryservice.product.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ottua.queryservice.product.dto.Product;
import ottua.queryservice.product.entity.ProductInfo;
import ottua.queryservice.product.entity.SeatInfo;
import ottua.queryservice.product.repository.ProductRepository;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> QueryProduct (Integer pageNum) {
        List<ProductInfo> productInfos =
                productRepository.findAllBy((Pageable) PageRequest.of(pageNum, 20, Sort.by("perform_start_date").ascending()));
        List<Product> products = new ArrayList<>();

        for (ProductInfo product: productInfos) {
            if (product.getStatus().equals("activate")) {
                Product oneProduct = new Product(
                        product.getId(),
                        product.getTitle(),
                        product.getPosterUrl(),
                        product.getStatus()
                );
                products.add(oneProduct);
            }
        }
        return products;
    }

}