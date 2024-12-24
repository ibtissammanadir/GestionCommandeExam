package org.example.serviceproduit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ServiceProduitApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProduitApplication.class, args);
    }

}
