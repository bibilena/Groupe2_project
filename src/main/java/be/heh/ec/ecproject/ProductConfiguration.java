package be.heh.ec.ecproject;

import be.heh.ec.ecproject.product.adapters.out.persistence.ProductPersistenceAdapter;
import be.heh.ec.ecproject.product.adapters.out.persistence.ProductRepository;
import be.heh.ec.ecproject.product.application.in.AllProductUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories
public class ProductConfiguration {

    @Autowired
    private ProductRepository productRepository;
    @Bean
    AllProductUseCase getAllPersonUseCase(){
        return new ProductPersistenceAdapter(productRepository);
    }

}
