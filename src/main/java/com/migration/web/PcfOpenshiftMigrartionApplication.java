package com.migration.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class PcfOpenshiftMigrartionApplication {

	public static void main(String[] args) {
		SpringApplication.run(PcfOpenshiftMigrartionApplication.class, args);
	}

}
