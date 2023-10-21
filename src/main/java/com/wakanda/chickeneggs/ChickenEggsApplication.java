package com.wakanda.chickeneggs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@RestController
@RequestMapping("/")
public class ChickenEggsApplication {

	@GetMapping
	public String getHomeTeste(){
		return "Chicken Eggs - API Home";
	}

	public static void main(String[] args) {
		SpringApplication.run(ChickenEggsApplication.class, args);
	}

}
