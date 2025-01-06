package ottua.queryservice.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/detail")
    public ResponseEntity QueryProductDetail (@RequestParam String id) {
        ProductDetailDto result = productService.QueryProductDetail(id);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping("/inventory")
    public ResponseEntity<ProductInventoryDto> QueryProductInventory (@RequestParam String id) {
        List<ProductInventoryDto> result = productService.QueryProductInventory(id);
        return new ResponseEntity(result, HttpStatus.OK);
    }

}
