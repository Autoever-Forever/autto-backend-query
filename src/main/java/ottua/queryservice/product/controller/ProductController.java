package ottua.queryservice.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ottua.queryservice.product.dto.Product;
import ottua.queryservice.product.dto.ProductDetailDto;
import ottua.queryservice.product.dto.ProductInventoryDto;
import ottua.queryservice.product.service.ProductService;
import java.util.List;

@RestController
@ResponseBody
@RequestMapping("")
public class ProductController {
    ProductService productService;

    public ProductController (ProductService productService){
        this.productService = productService;
    }
    // 상품 전체 조회
    @GetMapping("/")
    public ResponseEntity<List<Product>> QueryProduct (@RequestParam Integer pageNum) {
        List<Product> result = productService.QueryProduct(pageNum);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/detail")
    public ResponseEntity<ProductDetailDto> QueryProductDetail (@RequestParam String id) {
        ProductDetailDto result = productService.QueryProductDetail(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/inventory")
    public ResponseEntity<List<ProductInventoryDto>> QueryProductInventory (@RequestParam String id) {
        List<ProductInventoryDto> result = productService.QueryProductInventory(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
