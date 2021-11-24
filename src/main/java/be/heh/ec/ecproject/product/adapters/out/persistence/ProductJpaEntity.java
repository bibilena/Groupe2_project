package be.heh.ec.ecproject.product.adapters.out.persistence;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
public class ProductJpaEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long productId;

    @Column(name = "productName")
    private String productName;

    @Column(name = "productBrand")
    private String productBrand;

    @Column(name = "description")
    private String description;

}
