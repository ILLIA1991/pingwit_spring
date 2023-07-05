package product.repository;

import product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringDataProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAllByDescription(String description);

    List<Product> findAllByNameAndDescription(String name, String description);
}
