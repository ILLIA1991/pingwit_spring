package Product.Service;

import Product.Controller.ProductDTO.ProductDTO;

import java.util.Collection;
import java.util.List;

public interface ProductService {

    Collection<ProductDTO> getAllProducts();

    ProductDTO getById(Integer id);

    Integer createProduct(ProductDTO productToCreate);

    void deleteProduct(Integer id);


    List<ProductDTO> searchByDescription(String description);
}

