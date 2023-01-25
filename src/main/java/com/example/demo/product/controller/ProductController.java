package com.example.demo.product.controller;

import com.example.demo.product.model.Product;
import com.example.demo.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(path = "api/v1/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping(path = "/getProductBySku/{sku}")
    public Product getProductBySku(@PathVariable("sku") String sku) {
        return productService.getProductBySku(sku);
    }

    @GetMapping(path = "/getProductsByCategory/{category}")
    public List<Product> getProductsByCategory(@PathVariable("category") String category) {
        return productService.getProductsByCategory(category);
    }

    @GetMapping(path = "/getProductsFiltered")
    public List<Product> getProductsFiltered(
            @RequestParam(required = false) String categoryName,
            @RequestParam(required = false) String searchPhrase,
            @RequestParam(required = false) Double opinionAvgMin,
            @RequestParam(required = false) Double opinionAvgMax) {
        return productService.getProductsFiltered(categoryName, searchPhrase, opinionAvgMin, opinionAvgMax);
    }

    @PostMapping
    public void addNewProduct(@RequestBody Product product) {
        productService.addNewProduct(product);
    }

    @DeleteMapping(path="/removeProduct/{sku}")
    public void removeProduct(@PathVariable("sku") String productSku) {
        productService.removeProduct(productSku);
    }

    @PutMapping(path = "/updateProduct/{sku}")
    public void editProduct(@PathVariable("sku") String productSku,
                            @RequestParam(required = false) String name,
                            @RequestParam(required = false) String description,
                            @RequestParam(required = false) String category,
                            @RequestParam(required = false) Boolean visible) {
        productService.editProduct(productSku,name,description,category,visible);
    }
}
