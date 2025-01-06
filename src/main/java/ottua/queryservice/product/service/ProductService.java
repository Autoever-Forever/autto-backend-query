package ottua.queryservice.product.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ottua.queryservice.product.dto.Product;
import ottua.queryservice.product.entity.ProductInfo;
import ottua.queryservice.product.entity.Status;
import ottua.queryservice.product.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService {
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> QueryProduct (Integer pageNum) {
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<ProductInfo> productInfos = productRepository.findByStatus(Status.ACTIVE, pageRequest);


        List<Product> products = new ArrayList<>();
        for (ProductInfo productInfo: productInfos) {
            Product product = new Product(
                    productInfo.getId().toString(),
                    productInfo.getTitle(),
                    productInfo.getPosterUrl()
            );
            products.add(product);
        }
        return products;
    }

}