package com.shalini.receipe.Receipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.shalini.receipe.*")
@ComponentScan(basePackages={"com.shalini.receipe.*"})
@EntityScan("com.shalini.receipe.model")
public class ReceipeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReceipeApplication.class, args);
	}

}
