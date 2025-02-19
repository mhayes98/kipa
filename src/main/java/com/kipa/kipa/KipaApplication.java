package com.kipa.kipa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@EntityScan(basePackages = "com.kipa.kipa.User.User")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class KipaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KipaApplication.class, args);
	}

}