package org.kossowski.packon;


import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(  basePackages = { "none.none.none" })
public class InsertDBConfig {


    @Bean
    @ConfigurationProperties( prefix = "insert.datasource")
    public DataSource insertDataSource() {
        return DataSourceBuilder.create().build();
    }
}
