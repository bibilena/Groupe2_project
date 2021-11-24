package be.heh.ec.ecproject.product.adapters.in.web;

import be.heh.ec.ecproject.product.application.in.AllProductUseCase;
import be.heh.ec.ecproject.product.domain.Product;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTest {

    @LocalServerPort
    private int port;

    @MockBean
    private AllProductUseCase allProductsUseCase;

    @Test
    void getAllProducts(){
        List<Product> products = new ArrayList<>();
        products.add(new Product(4L, "Café", "Grain d'or", 10));

        Map<String, Object> jsonProducts = new LinkedHashMap<>();
        jsonProducts.put("products", products);

        Mockito.when(allProductsUseCase.getAllProducts()).thenReturn(jsonProducts);

        baseURI ="http://localhost/api";
        given().
                port(port).
                when().
                    get("/products").
                then().
                    statusCode(200).
                    body("products[0].productName", equalTo("Café"));
    }

}
