package Product.service;

import Product.controller.ProductDTO.ProductDTO;
import Product.controller.ProductDTO.ProductFilterDTO;
import Product.exception.ProductNotFoundException;
import Product.repository.model.Product;
import Product.productconverter.ProductConverter;
import Product.repository.PagingProductRepository;
import Product.repository.SpringDataProductRepository;
import Product.validator.ProductValidator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Collection;
import java.util.List;

@Service
@Transactional(readOnly = true)
public  class ProductServiceImpl implements ProductService {

    private final SpringDataProductRepository springDataProductRepository;
    private final ProductConverter productConverter;
    private final ProductValidator productValidator;
    private final PagingProductRepository pagingProductRepository;

    public ProductServiceImpl(SpringDataProductRepository springDataProductRepository, ProductConverter productConverter, ProductValidator productValidator, PagingProductRepository pagingProductRepository) {
        this.springDataProductRepository = springDataProductRepository;
        this.productConverter = productConverter;
        this.productValidator = productValidator;
        this.pagingProductRepository = pagingProductRepository;
    }
    @Override
    public List<ProductDTO> getAllProducts() {
        Collection<Product> all = springDataProductRepository.findAll();
        return productConverter.convertToDto(all);
    }
    @Override
    public ProductDTO getById(Integer id) {
        Product product =  springDataProductRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found: " + id));
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
    public List<ProductDTO> search(ProductFilterDTO filter) {
        String nameLike = "%" + filter.getName() + "%";
        String descriptionLike = "%" + filter.getDescription() + "%";
        List<Product> allByNameOrDescription = springDataProductRepository.findAllByNameLikeOrDescriptionLike(nameLike, descriptionLike);
        return productConverter.convertToDto(allByNameOrDescription);
    }

    @Override
    public Page<ProductDTO> getPage(Pageable pageable) {
        Page<Product> productPage = pagingProductRepository.findAll(pageable);
        List<ProductDTO> productDTOS = productConverter.convertToDto(productPage.getContent());
        return new PageImpl<>(productDTOS, productPage.getPageable(), productPage.getTotalPages());
    }


}
