package de.tekup.internshipapplicationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class InternshipApplicationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InternshipApplicationServiceApplication.class, args);
	}

}
