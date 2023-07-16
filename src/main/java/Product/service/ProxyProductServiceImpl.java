package Product.service;

import Product.controller.ProductDTO.ProductDTO;
import Product.controller.ProductDTO.ProductFilterDTO;
import Product.productconverter.ProductConverter;
import Product.repository.PagingProductRepository;
import Product.repository.SpringDataProductRepository;
import Product.validator.ProductValidator;
import org.hibernate.tool.schema.spi.ExceptionHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.TransactionManager;

import java.util.List;

public class ProxyProductServiceImpl extends ProductServiceImpl{

    private TransactionManager transactionManager;

    public ProxyProductServiceImpl(SpringDataProductRepository springDataProductRepository, ProductConverter productConverter, ProductValidator productValidator, PagingProductRepository pagingProductRepository) {
        super(springDataProductRepository, productConverter, productValidator, pagingProductRepository);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
           return super.getAllProducts();

    }

    @Override
    public ProductDTO getById(Integer id) {
        return super.getById(id);
    }

    @Override
    public Integer createProduct(ProductDTO productToCreate) {
        return super.createProduct(productToCreate);
    }

    @Override
    public void deleteProduct(Integer id) {
        super.deleteProduct(id);
    }

    @Override
    public List<ProductDTO> searchByDescription(String description) {
        return super.searchByDescription(description);
    }

    @Override
    public ProductDTO updateProduct(Integer id, ProductDTO productToUpdate) {
        return super.updateProduct(id, productToUpdate);
    }

    @Override
    public List<ProductDTO> search(ProductFilterDTO filter) {
        return super.search(filter);
    }

    @Override
    public Page<ProductDTO> getPage(Pageable pageable) {
        return super.getPage(pageable);
    }
}
