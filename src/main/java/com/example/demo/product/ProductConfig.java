package com.example.demo.product;

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
                    "Majtki",
                    "Bielizna",
                    "Ładne majtki brazyliany",
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
                    "Stanik",
                    "Bielizna",
                    "Stanik z push upem",
                    4.3,
                    true
            );
            Product product6 = new Product(
                    "sdww",
                    "Figi",
                    "Bielizna",
                    "Majteczki w kropeczki hohohoho",
                    4.3,
                    true
            );

            repository.saveAll(
                    List.of(product1,product2,product3,product4,product5,product6)
            );
        };
    }
}
