package com.HealthCare.MedicareServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MedicareServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicareServerApplication.class, args);
	}

}
