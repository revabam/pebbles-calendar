package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.CrossOrigin;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This microservice persists and retrieves calendar information from a database
 * This is the link to the pebbles-calendar repo
 * This service is using Swagger to document all the endpoints
 * https://github.com/revabam/pebbles-calendar
 * 
 * @author Alicia Douglas | Spark1806-USF-Java | Steven Kelsey
 * @author Obosa Nosa-Igiebor | Spark1806-USF-Java | Steven Kelsey
 * @author Marcin Salamon | Spark1806-USF-Java | Steven Kelsey
 * @author Joshua Maciejewski | Spark1806-USF-Java | Steven Kelsey
 */
@CrossOrigin
@EnableEurekaClient
@SpringBootApplication
@EnableSwagger2
@EnableScheduling
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.revature"))
				.paths(PathSelectors.any()).build();
	}
}
