package Product.Repository;

import Product.Model.Product;

import java.util.Collection;
import java.util.List;

public interface ProductRepository {

     Product getById(Integer id);

     Collection<Product> getAll();

     void delete(Integer productId);

     Integer createProduct(Product productToCreate);


    List<Product> searchByName(String name);
}


