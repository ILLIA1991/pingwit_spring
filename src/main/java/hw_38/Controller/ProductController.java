package hw_38.Controller;

import hw_38.Model.Product;
import hw_38.Repository.ProductSearchRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductSearchRepository productSearchRepository;

    public ProductController(ProductSearchRepository productSearchRepository) {
        this.productSearchRepository = productSearchRepository;
    }
    @GetMapping("/{id}")
    public Product getById(@PathVariable Integer id) {
        return productSearchRepository.getById(id);
    }

    @GetMapping
    public Collection<Product> getAll() {
        return productSearchRepository.getAll();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        productSearchRepository.delete(id);
        return "Bardzo dobrze";
    }

    @GetMapping("/page")
    public String requestProduct() {
        return  """
                "<html><body><h1>
                products.put(1, new Product(11, "AppleWatch", "Pro", 500.0));
                products.put(2, new Product(12, "IPhone 25", "Pro", 10000.0));
                products.put(3, new Product(13, "MackBook Air", "M10", 50000.0));
                 !</h1></body></html>";
                """;
                
    }
    @Value("${application.greeting}")
    public String greeting;

    @GetMapping("/privetiki_pistoletiki")
    public String greet() {
        return greeting;
    }

    @PostMapping
    public Integer createProduct(@RequestBody Product productToCreate)  {
        return productSearchRepository.createProduc(productToCreate);
    }


}
