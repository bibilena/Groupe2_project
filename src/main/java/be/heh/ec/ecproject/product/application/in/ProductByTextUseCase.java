package be.heh.ec.ecproject.product.application.in;

import java.util.Map;

public interface ProductByTextUseCase {

    Map<String, Object> getProductsByText(String text);

}
