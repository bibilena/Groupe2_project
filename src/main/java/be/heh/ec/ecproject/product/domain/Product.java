package be.heh.ec.ecproject.product.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Product {

    @Getter
    private Long id;
    @Getter
    private String productName;
    @Getter
    private String productBrand;
    @Getter
    private String description;

    public Product(Long id, String productName, String productBrand, String description) {
        this.id = id;
        this.productName = productName;
        this.productBrand = productBrand;
        this.description = description;
    }

}
