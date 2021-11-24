package be.heh.ec.ecproject.product.adapters.out.persistence;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
public class ProductJpaEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "productid")
    private Long productId;

    @Column(name = "productname")
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private int price;

}
