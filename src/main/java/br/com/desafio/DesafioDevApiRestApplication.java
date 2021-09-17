package br.com.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"br.com.desafio.*"})
@EnableJpaRepositories(basePackages ={"br.com.desafio.*"})
@EntityScan(basePackages ={"br.com.desafio.*"})
public class DesafioDevApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioDevApiRestApplication.class, args);
	}

}
