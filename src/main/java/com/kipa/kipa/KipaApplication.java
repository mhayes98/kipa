package com.kipa.kipa;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
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

	@Value("${SPRING_DATASOURCE_URL:default_value}")
private String datasourceUrl;

@Value("${SPRING_DATASOURCE_USERNAME:default_value}")
private String datasourceUsername;

@Value("${SPRING_DATASOURCE_PASSWORD:default_value}")
private String datasourcePassword;

@PostConstruct
public void logEnvVars() {
    System.out.println("Datasource URL: " + datasourceUrl);
    System.out.println("Datasource Username: " + datasourceUsername);
    System.out.println("Datasource Password: " + datasourcePassword);
}

}