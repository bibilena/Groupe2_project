package be.heh.ec.ecproject.product.domain;

import lombok.Getter;

public class Product {

    @Getter
    private Long id;
    @Getter
    private String productName;
    @Getter
    private String description;
    @Getter
    private int price;

    public Product(){}

    public Product(Long id, String productName, String description, int price) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.price = price;
    }

}
