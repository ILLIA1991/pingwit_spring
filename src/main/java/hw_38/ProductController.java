package hw_38;

import hw_37.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
