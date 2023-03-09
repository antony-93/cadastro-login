package br.com.senai.crudmysqlspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(WebConfig.class)
public class CrudMysqlSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudMysqlSpringApplication.class, args);
	}

}
