package be.heh.ec.ecproject.product.domain;

import lombok.Getter;

public class Product {

    @Getter
    private Long id;
    @Getter
    private String productName;
    @Getter
    private String productBrand;
    @Getter
    private String description;

    public Product(){}

    public Product(Long id, String productName, String productBrand, String description) {
        this.id = id;
        this.productName = productName;
        this.productBrand = productBrand;
        this.description = description;
    }

}
