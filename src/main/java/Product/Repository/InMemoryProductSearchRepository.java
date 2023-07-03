package Product.Repository;

import Product.Model.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryProductSearchRepository {
     private Map<Integer, Product> products = new HashMap<>();

     @PostConstruct
     public void init() {
         products.put(1, new Product(11, "AppleWatch", "Pro", 500.0));
         products.put(2, new Product(12, "IPhone 25", "Pro", 10000.0));
         products.put(3, new Product(13, "MackBook Air", "M10", 50000.0));

     }


     public Product getById( Integer id) {
         Product product = products.get(id);
         if (product == null) {
             throw new RuntimeException("Product not found");
         } else {
             return product;
         }
     }


     public Collection<Product> getAll() {
         return products.values();
    }

    public void delete(Integer productId) {
         products.remove(productId);

    }

    public Integer createProduct(Product productToCreate) {
         products.put(productToCreate.id(), productToCreate);
         return productToCreate.id();
    }


}
