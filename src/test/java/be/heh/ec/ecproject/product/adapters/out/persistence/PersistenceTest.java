package be.heh.ec.ecproject.product.adapters.out.persistence;

import be.heh.ec.ecproject.product.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import({ProductPersistenceAdapter.class})
public class PersistenceTest {

    @Autowired
    private ProductRepository productRepository;

    private ProductPersistenceAdapter productPersistenceAdapter;

    @Test
    @Sql({"createTable.sql","products.sql"})
    void getAllProducts(){
        productPersistenceAdapter = new ProductPersistenceAdapter(productRepository);
        Map<String, Object> map = new HashMap<>();
        ArrayList<Product> list;

        map = productPersistenceAdapter.getAllProducts();

        list = (ArrayList<Product>)map.get("products");

    }

}
