package org.kossowski.packon;

import javax.faces.webapp.FacesServlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableJpaRepositories
public class PackonApplication {
	
	public static void main( String[] args ) {
	
		SpringApplication.run( PackonApplication.class  , args);
	}

	
//	 @Bean
//	 public ServletRegistrationBean facesServletRegistration() {
//
//	     ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new FacesServlet());
//	     servletRegistrationBean.addUrlMappings("/faces/*");
//	     servletRegistrationBean.setLoadOnStartup(1);
//	     return servletRegistrationBean;
//	 }
	
}
