package Product.repository;

import Product.repository.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PagingProductRepository extends PagingAndSortingRepository<Product, Integer> {
}
