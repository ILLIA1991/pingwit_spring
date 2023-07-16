package Product.repository;

import Product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface PagingProductRepository extends PagingAndSortingRepository<Product, Integer> {

}

