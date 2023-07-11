package Product.service;

import Product.controller.ProductDTO.ProductDTO;
import Product.controller.ProductDTO.ProductFilterDTO;
import Product.model.Product;
import Product.productconverter.ProductConverter;
import Product.repository.SpringDataProductRepository;
import Product.validator.ProductValidator;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final SpringDataProductRepository springDataProductRepository;
    private final ProductConverter productConverter;
    private final ProductValidator productValidator;

    public ProductServiceImpl(SpringDataProductRepository springDataProductRepository, ProductConverter productConverter, ProductValidator productValidator) {
        this.springDataProductRepository = springDataProductRepository;
        this.productConverter = productConverter;
        this.productValidator = productValidator;
    }
    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> getAllProducts() {
        Collection<Product> all = springDataProductRepository.findAll();
        return productConverter.convertToDto(all);
    }
    @Override
    @Transactional(readOnly = true)
    public ProductDTO getById(Integer id) {
        Product product =  springDataProductRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found" + id));
        return productConverter.convertToDto(product);
    }
    @Override
    @Transactional
    public Integer createProduct(ProductDTO productToCreate) {
        productValidator.validateProduct(productToCreate);
        Product product = productConverter.convertToEntity(productToCreate);
        Product saveProduct = springDataProductRepository.save(product);
        return saveProduct.getId();
    }
    @Override
    @Transactional
    public void deleteProduct(Integer id) {
        Product product =  springDataProductRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found" + id));
        springDataProductRepository.delete(product);

    }


    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> searchByDescription(String description) {
        List<Product> productsList = springDataProductRepository.findAllByNameLikeOrDescriptionLike(description, description);
        return productConverter.convertToDto(productsList);
    }

    @Override
    @Transactional
    public ProductDTO updateProduct(Integer id, ProductDTO productToUpdate) {
        Product product =  springDataProductRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found" + id));
        Product entityToUpdate = productConverter.convertToEntity(productToUpdate);
        entityToUpdate.setId(id);
        Product updateEntity = springDataProductRepository.save(entityToUpdate);
        return productConverter.convertToDto(updateEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> search(@NotNull ProductFilterDTO filter) {
        String nameLike = "%" + filter.getName() + "%";
        String descriptionLike = "%" + filter.getDescription() + "%";
        List<Product> allByNameOrDescription = springDataProductRepository.findAllByNameLikeOrDescriptionLike(nameLike, descriptionLike);
        return productConverter.convertToDto(allByNameOrDescription);
    }
}
