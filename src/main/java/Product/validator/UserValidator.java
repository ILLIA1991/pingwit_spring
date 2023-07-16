package Product.validator;

import Product.controller.ProductDTO.UserDTO;
import Product.exception.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {

    public void validateUser(UserDTO userDTO) {
        if (!userDTO.getEmail().endsWith("@pingwit.pl")) {
            throw new ValidationException("User email should be on @pingwit.pl!");
        }
    }
}
