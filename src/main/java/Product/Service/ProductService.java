package Product.Service;

import Product.Controller.ProductDTO.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getAllProducts();

    ProductDTO getById(Integer id);

    Integer createProduct(ProductDTO productDTO);

    void deleteById(Integer id);

    List<ProductDTO> searchByName(String name);




}

