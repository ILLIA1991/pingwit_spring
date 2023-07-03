package Product.Controller;

import Product.Controller.ProductDTO.ProductDTO;
import Product.Model.Product;
import Product.Service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ProductDTO getById(@PathVariable Integer id) {
        return productService.getById(id);
    }

    @GetMapping("/product")
    public List<ProductDTO> searchByName(@RequestParam String name) {
        return productService.searchByName(name);
    }

    @GetMapping
    public List<ProductDTO> getAll() {
        return productService.getAllProducts();

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        productService.deleteById(id);

    }

    @PostMapping
    public Integer createProduct(@RequestBody ProductDTO productToCreate)  {
        return productService.createProduct(productToCreate);

    }



}
