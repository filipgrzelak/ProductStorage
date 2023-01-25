package com.example.demo.product.service;

import com.example.demo.product.model.Product;
import com.example.demo.product.database.interfaces.ProductRepository;
import com.example.demo.product.exceptions.ProductDoesNotExist;
import com.example.demo.product.exceptions.ProductWithThisSkuAlreadyExist;
import com.example.demo.product.exceptions.ProductWithThisSkuDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductBySku(String sku) {

        if (productRepository.findProductBySku(sku).isEmpty()) {
            throw new ProductWithThisSkuDoesNotExistException("Product does not exist");
        }
        return productRepository.findProductBySku(sku).get();
    }

    public List<Product> getProductsByCategory(String category) {
        Optional<List<Product>> productsOptional = productRepository.findProductsByCategory(category);
        if (productsOptional.isEmpty()) {
            throw new ProductWithThisSkuDoesNotExistException("Products for this category does not exist");
        }
        return productsOptional.get();
    }

    public List<Product> getProductsFiltered(String category,
                                             String searchPhrase,
                                             Double opinionAvgMin,
                                             Double opinionAvgMax) {
        Optional<List<Product>> products = productRepository
                .findFiltered(category, searchPhrase, opinionAvgMin, opinionAvgMax);
        if (!products.isPresent()) {
            throw new ProductDoesNotExist("Product does not exist");
        }
        return products.get();
    }

    public void addNewProduct(Product product) {
        Optional<Product> productOptional = productRepository
                .findProductBySku(product.getSku());
        if (productOptional.isPresent()) {
            throw new ProductWithThisSkuAlreadyExist("Product with this sku already exist");
        }
        productRepository.save(product);
    }

    public void removeProduct(String productSku) {
        Optional<Product> productOptional = productRepository.findProductBySku(productSku);
        if (!productOptional.isPresent()) {
            throw new ProductDoesNotExist("Product does not exist");
        }
        productRepository.delete(productOptional.get());
    }

    @Transactional
    public void editProduct(String productSku,
                            String name,
                            String description,
                            String category,
                            Boolean visible) {
        Product product = productRepository.findProductBySku(productSku)
                .orElseThrow(() -> new ProductDoesNotExist(
                        "Product does not exist"
                ));
        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(product.getName(), name)) {
            product.setName(name);
        }

        if (description != null &&
                description.length() > 0 &&
                !Objects.equals(product.getDescription(), description)) {
            product.setDescription(description);
        }

        if (category != null &&
                category.length() > 0 &&
                !Objects.equals(product.getCategory(), category)) {
            product.setCategory(category);
        }

        if (visible != null &&
                !Objects.equals(product.isVisible(), visible)) {
            product.setVisible(visible);
        }
    }
}
