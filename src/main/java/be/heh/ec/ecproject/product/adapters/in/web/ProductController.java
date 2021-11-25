package be.heh.ec.ecproject.product.adapters.in.web;

import be.heh.ec.ecproject.product.application.in.ProductByTextUseCase;
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
    private final ProductByTextUseCase productByText;
/*
    @GetMapping("/products")
    public Map<String, Object> getAllProducts() {
        return allProductsUseCase.getAllProducts();
    }
*/
    @GetMapping("/products")
    public Map<String, Object> getAllProducts(@RequestParam(required = false) String text) {
        if(text != null){
            return productByText.getProductsByText(text);
        }
        return allProductsUseCase.getAllProducts();
    }
}
