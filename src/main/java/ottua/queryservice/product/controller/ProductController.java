package ottua.queryservice.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ottua.queryservice.product.dto.ProductDetailDto;
import ottua.queryservice.product.dto.ProductInventoryDto;
import ottua.queryservice.product.entity.ProductInfo;
import ottua.queryservice.product.repository.ProductRepository;
import ottua.queryservice.product.service.ProductService;

import java.util.List;
import java.util.UUID;

@RestController
@ResponseBody
@RequestMapping("")
public class ProductController {
    ProductService productService;


    public ProductController (ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/detail")
    public ResponseEntity QueryProductDetail (String id) {

        List<ProductDetailDto> result = productService.QueryProductDetail(id);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping("/inventory")
    public ResponseEntity<ProductInventoryDto> QueryProductInventory (String id) {
        List<ProductInventoryDto> result = productService.QueryProductInventory(id);
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
