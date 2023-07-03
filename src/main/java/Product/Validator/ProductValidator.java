package Product.Validator;

import Product.Controller.ProductDTO.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductValidator {

    public void validateProduct(ProductDTO productDTO) {
        String name = productDTO.getName();
        if(name.length() == 0 || name.contains("\\d+")) {
            throw new ValidationException("Name is invalid!");
        }

    }
}
