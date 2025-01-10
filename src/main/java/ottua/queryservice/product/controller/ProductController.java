package ottua.queryservice.product.controller;

import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ottua.queryservice.common.response.BaseApiResponse;
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

    @GetMapping("/")
    public BaseApiResponse<?> QueryProduct (@RequestParam Integer pageNum) throws IllegalArgumentException, Exception {
        return BaseApiResponse.success("상품 전체 리스트 조회 성공", productService.QueryProduct(pageNum));
    }

    @GetMapping("/detail")
    public BaseApiResponse<?> QueryProductDetail (@RequestParam String id) throws IllegalArgumentException, Exception {
        return BaseApiResponse.success("상품 상세 정보 조회 성공",productService.QueryProductDetail(id));
    }

    @GetMapping("/inventory")
    public BaseApiResponse<?> QueryProductInventory (@RequestParam String id) throws IllegalArgumentException, Exception{
        return BaseApiResponse.success("상품 날짜 및 재고 조회 성공", productService.QueryProductInventory(id));
    }

}
