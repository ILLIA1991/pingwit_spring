package Product.Service;

import Product.Controller.ProductDTO.ProductDTO;
import Product.Model.Product;
import Product.ProductConverter.ProductConverter;
import Product.Repository.ProductRepository;
import Product.Validator.ProductValidator;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductConverter productConverter;
    private final ProductValidator productValidator;

    public ProductServiceImpl(ProductRepository productRepository, ProductConverter productConverter, ProductValidator productValidator) {
        this.productRepository = productRepository;
        this.productConverter = productConverter;
        this.productValidator = productValidator;
    }
    @Override
    public List<ProductDTO> getAllProducts() {
        Collection<Product> all = productRepository.getAll();
        return productConverter.convertToDto(all);
    }
    @Override
    public ProductDTO getById(Integer id) {
        Product product =  productRepository.getById(id);
        return productConverter.convertToDto(product);
    }
    @Override
    public Integer createProduct(ProductDTO productToCreate) {
        productValidator.validateProduct(productToCreate);
        Product product = productConverter.convertToEntity(productToCreate);
        return productRepository.createProduct(product);
    }
    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteProduct(id);

    }


    @Override
    public List<ProductDTO> searchByDescription(String description) {
        List<Product> productsList = productRepository.searchByDescription(description);
        return productConverter.convertToDto(productsList);
    }
}
