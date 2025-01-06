package ottua.queryservice.product.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.ls.LSInput;
import ottua.queryservice.product.dto.Product;
import ottua.queryservice.product.entity.ProductInfo;
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
    // controller
    // 상품 전체 조회
    @GetMapping("/")
    public ResponseEntity QueryProduct (@RequestParam Integer pageNum) {
        List<Product> result = productService.QueryProduct(pageNum);
        return new ResponseEntity(result, HttpStatus.OK);
    }
}