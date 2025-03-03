package com.example.faveFood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class FaveFoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(FaveFoodApplication.class, args);
	}


}
