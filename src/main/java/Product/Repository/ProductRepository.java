package Product.Repository;

import Product.Model.Product;

import java.util.Collection;
import java.util.List;

public interface ProductRepository {


     Collection<Product> getAll();

     void deleteProduct(Integer productId);

     Integer createProduct(Product productToCreate);


    List<Product> searchByDescription(String description);



    Product getById(Integer id);

}


