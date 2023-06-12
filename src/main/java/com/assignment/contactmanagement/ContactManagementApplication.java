package com.assignment.contactmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.assignment.contactmanagement.config.RSAKeyConfig;

@EnableConfigurationProperties(RSAKeyConfig.class)
@SpringBootApplication
public class ContactManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactManagementApplication.class, args);
	}
}
