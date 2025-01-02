package ottua.queryservice.product.dto;

import ottua.queryservice.product.entity.Status;

import java.util.UUID;

public class Product {

    private UUID id;
    private String title;
    private String posterUrl;
    private Status status;

    public Product(UUID id, String title, String posterUrl, Status status) {
        this.id = id;
        this.title = title;
        this.posterUrl = posterUrl;
        this.status = status;

    }
}
