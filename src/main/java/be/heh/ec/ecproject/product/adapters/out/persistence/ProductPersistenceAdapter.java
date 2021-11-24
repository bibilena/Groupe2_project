package be.heh.ec.ecproject.product.adapters.out.persistence;

import be.heh.ec.ecproject.product.application.in.AllProductUseCase;
import be.heh.ec.ecproject.product.domain.Product;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class ProductPersistenceAdapter implements AllProductUseCase {

    private final ProductRepository productRepository;

    @Override
    public Map<String, Object> getAllProducts() {
        List<ProductJpaEntity> productJpaList = productRepository.findAll();

        List<Product> productList = new ArrayList<>();
        Map<String,Object> mapProduct = new HashMap<>();

        for (ProductJpaEntity product: productJpaList) {
            productList.add(new Product(product.getProductId(),product.getProductName(),product.getProductBrand(),product.getDescription()));
        }

        mapProduct.put("products",productList);
        return mapProduct;
    }

}
