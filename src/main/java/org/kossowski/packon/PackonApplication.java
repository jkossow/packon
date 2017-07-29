package org.kossowski.packon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PackonApplication {
	
	public static void main( String[] args ) {
	
		SpringApplication.run( PackonApplication.class  , args);
	}

}
