package com.ust.Laptop_recommendation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages={"com.ust.Laptop_recommendation", "com.speedment.jpastreamer"})
public class LaptopRecommendationApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaptopRecommendationApplication.class, args);
	}

}
