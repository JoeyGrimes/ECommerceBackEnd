package com.bookshop.springbootrestdatabookshopmaven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages={
"com.bookshop.springbootrestbookshopmaven.entity", "com.bookshop.springbootrestbookshopmaven.dao","com.bookshop.springbootrestbookshopmaven.service","com.bookshop.springbootrestbookshopmaven.pojo", "com.bookshop.springbootrestbookshopmaven.controller"})
@EntityScan("com.bookshop.springbootrestbookshopmaven")

public class SpringBootRestDataBookshopMavenApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestDataBookshopMavenApplication.class, args);
	}

}
