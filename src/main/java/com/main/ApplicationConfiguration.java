package com.main;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import com.main.service.RoleFunctionService;

@Configuration
@EnableJpaRepositories("com.main.repository")
@EntityScan("com.main.entity")
@PropertySource("classpath:db/db-config.properties")
@EnableJpaAuditing
@ServletComponentScan("com.main.filters")
public class ApplicationConfiguration {


	
	public ApplicationConfiguration(){
		
	}
	
	/*@Bean
	public DataSource dataSource(){
		DataSource datasource = (new EmbeddedDatabaseBuilder())
				.addScript("classpath:db/schema.sql")
				.addScript("classpath:db/data.sql").build();
		return datasource;
	}*/
	
}
