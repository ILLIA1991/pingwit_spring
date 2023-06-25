package hw_38;

import hw_37.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductSearchRepository {
     private Map<Integer, Product> products = new HashMap<>();

     @PostConstruct
     public void init() {
         products.put(1, new Product(11, "AppleWatch", "Pro", 500.0));
         products.put(2, new Product(12, "IPhone 25", "Pro", 10000.0));
         products.put(3, new Product(13, "MackBook Air", "M10", 50000.0));

     }

     public Product getById(Integer id) {
         return products.get(id);
     }

     public Collection<Product> getAll() {
         return products.values();
    }

    public void delete(Integer productId) {
         products.remove(productId);

    }
}
