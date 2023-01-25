package com.example.demo.product.database.interfaces;

import com.example.demo.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository
        extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.sku = ?1")
    Optional<Product> findProductBySku(String sku);

    @Query("SELECT p FROM Product p WHERE p.category in ?1")
    Optional<List<Product>> findProductsByCategory(String categoryName);

    @Query(
            "SELECT p FROM Product p WHERE " +
                    "(?1 is null or p.category = ?1)" +
                    "and (?2 is null or p.description like %?2%)" +
                    "and (?3 is null or p.opinion >= ?3)" +
                    "and (?4 is null or p.opinion <= ?4)"
    )
    Optional<List<Product>> findFiltered(String category,
                                         String searchPhrase,
                                         Double opinionAvgMin,
                                         Double opinionAvgMax);

}
