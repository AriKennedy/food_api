package com.example.faveFood.faveFood;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class FoodConfig {

    @Bean
    CommandLineRunner commandLineRunner(FoodRepositry foodRepositry) {
        return args -> {
            Food pizza = new Food(
                    "Pizza",
                    "Italy",
                    "Savory",
                    15
            );

            Food sushi = new Food(
                    "Sushi",
                    "Japan",
                    "Seafood",
                    5
            );
            foodRepositry.saveAll(
                    List.of(pizza, sushi)
            );
        };
    }
}
