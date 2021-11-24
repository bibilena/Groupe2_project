package be.heh.ec.ecproject.product.adapters.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import be.heh.ec.ecproject.product.application.in.AllProductUseCase;
import java.util.Map;

@RestController
@RequestMapping(path="/api", produces="application/json")
@CrossOrigin(origins="*")
@RequiredArgsConstructor
public class ProductController {

    private final AllProductUseCase allProductsUseCase;

    @GetMapping("/products")
    public Map<String, Object> getAllProducts() {
        return allProductsUseCase.getAllProducts();
    }

}
