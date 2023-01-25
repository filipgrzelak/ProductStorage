package com.example.demo.product.configuration;

import com.example.demo.product.model.Product;
import com.example.demo.product.database.interfaces.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            ProductRepository repository) {
        return args -> {
            Product product1 = new Product(
                    "idaes",
                    "Koszulka",
                    "Outfit",
                    "Koszulka z nadrukiem AC/DC",
                    4.0,
                    true
            );

            Product product2 = new Product(
                    "asda",
                    "Skarpetki",
                    "Bielizna",
                    "Skarpetki w bociany",
                    3.5,
                    true
            );
            Product product3 = new Product(
                    "vv",
                    "Młotek",
                    "Ogród",
                    "Solidny przyrząd do ogrodu",
                    4.9,
                    true
            );
            Product product4 = new Product(
                    "xa",
                    "Okulary",
                    "Wypoczynek",
                    "Idealne na słoneczną pogodę",
                    4.0,
                    false
            );
            Product product5 = new Product(
                    "sd",
                    "Kolczyki",
                    "Biżuteria",
                    "Kolczyki ze złota",
                    4.3,
                    true
            );
            Product product6 = new Product(
                    "sdww",
                    "Szpadel",
                    "Ogród",
                    "Kopie najlepsze dziury",
                    4.3,
                    true
            );

            repository.saveAll(
                    List.of(product1,product2,product3,product4,product5,product6)
            );
        };
    }
}
