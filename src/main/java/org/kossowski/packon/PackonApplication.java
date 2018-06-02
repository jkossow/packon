package org.kossowski.packon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
//@EnableCaching
public class PackonApplication {
	
	public static void main( String[] args ) {
	
		SpringApplication.run( PackonApplication.class  , args );
	}

// test branch develo
// drugi commit
// trzeci commit
	
//	 @Bean
//	 public ServletRegistrationBean facesServletRegistration() {
//
//	     ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new FacesServlet());
//	     servletRegistrationBean.addUrlMappings("/faces/*");
//	     servletRegistrationBean.setLoadOnStartup(1);
//	     return servletRegistrationBean;
//	 }
	
}
