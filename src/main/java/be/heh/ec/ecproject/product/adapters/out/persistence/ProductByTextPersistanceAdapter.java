package be.heh.ec.ecproject.product.adapters.out.persistence;

import be.heh.ec.ecproject.product.application.in.ProductByTextUseCase;
import be.heh.ec.ecproject.product.domain.Product;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class ProductByTextPersistanceAdapter implements ProductByTextUseCase {

    private final ProductRepository productRepository;

    @Override
    public Map<String, Object> getProductsByText(String text) {
        List<ProductJpaEntity> productJpaList = productRepository.findAll();

        List<Product> productList = new ArrayList<>();
        Map<String,Object> mapProduct = new HashMap<>();

        for (ProductJpaEntity product: productJpaList) {
            if(product.getProductName().contains(text)){
                productList.add(new Product(product.getProductId(),product.getProductName(),product.getDescription(), product.getPrice()));
            }
        }

        mapProduct.put("products",productList);
        return mapProduct;
    }

}
