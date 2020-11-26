package com.capg.fss;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@EnableSwagger2
@EnableEurekaClient
@SpringBootApplication
@EnableAutoConfiguration
public class FlightScheduleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightScheduleServiceApplication.class, args);
	}
	 @Bean
	    public Docket produceApi() {
	    	return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.capg.fss")).build();
	    }
}
