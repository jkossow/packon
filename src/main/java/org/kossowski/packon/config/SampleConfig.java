package org.kossowski.packon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleConfig {
   
     @Bean
     public SampleApplicationBean sab() {
        return new SampleApplicationBean();
     }

}
