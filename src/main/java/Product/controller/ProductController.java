package product.controller;

import product.controller.ProductDTO.ProductDTO;
import product.controller.ProductDTO.ProductFilterDTO;
import product.service.ProductService;
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

    @GetMapping("/search")
    public List<ProductDTO> searchByDescription(@RequestParam String description) {
        return productService.searchByDescription(description);
    }

    @GetMapping
    public Collection<ProductDTO> getAll() {
        return productService.getAllProducts();

    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);

    }

    @PostMapping
    public Integer createProduct(@RequestBody ProductDTO productToCreate)  {
        return productService.createProduct(productToCreate);

    }

    @PutMapping("/{id}")
    public ProductDTO update(@PathVariable Integer id, @RequestBody ProductDTO productToUpdate) {
        return productService.updateProduct(id, productToUpdate);
    }

    @PostMapping("/search")
    public List<ProductDTO> search(@RequestBody ProductFilterDTO filter) {
        return productService.search(filter);
    }



}
