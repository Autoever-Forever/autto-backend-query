package ottua.queryservice.product.dto;

// dto
// 상품 전체 조회
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import ottua.queryservice.product.entity.Status;

import java.util.UUID;

@Data
@Getter
public class Product {

    private String id;
    private String title;
    private String posterUrl;

    public Product(String id, String title, String posterUrl) {
        this.id = id;
        this.title = title;
        this.posterUrl = posterUrl;
    }
}
