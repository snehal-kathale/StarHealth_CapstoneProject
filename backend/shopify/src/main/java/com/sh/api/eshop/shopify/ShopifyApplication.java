package com.sh.api.eshop.shopify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
@SpringBootApplication
@ConfigurationProperties(prefix = "application.properties")
public class ShopifyApplication {

	public static void main(String[] args) {

		SpringApplication.run(ShopifyApplication.class, args);

	}
}
