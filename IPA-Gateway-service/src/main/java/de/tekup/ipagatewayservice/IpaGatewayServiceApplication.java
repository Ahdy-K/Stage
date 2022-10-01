package de.tekup.ipagatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
public class IpaGatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(IpaGatewayServiceApplication.class, args);
    }

}
