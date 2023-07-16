package Product.validator;

import Product.controller.ProductDTO.ProductDTO;
import Product.exception.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class ProductValidator {

    public void validateProduct(ProductDTO productDTO) {

        if(productDTO.getName().endsWith("$")) {
            throw new ValidationException("Not found name");
        }
        if(productDTO.getDescription().endsWith("$")) {
            throw new ValidationException("Not found description");

        }

    }
}
