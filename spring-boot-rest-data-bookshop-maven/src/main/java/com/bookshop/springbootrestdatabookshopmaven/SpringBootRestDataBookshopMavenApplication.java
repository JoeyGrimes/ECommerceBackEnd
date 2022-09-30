package com.bookshop.springbootrestdatabookshopmaven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication//(scanBasePackages = {"com.bookshop.springbootrestdatabookshopmaven.controller"})
//@EnableJpaRepositories(basePackages = "com.bookshop.springbootrestdatabookshopmaven.dao")
@EntityScan(basePackages = "com.bookshop.springbootrestdatabookshopmaven.entity")

public class SpringBootRestDataBookshopMavenApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestDataBookshopMavenApplication.class, args);
	}

}
                                                                                                                                                    