package com.flyway.migrationoracle.demoApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableAutoConfiguration(exclude = RepositoryRestMvcAutoConfiguration.class)
@EnableJpaRepositories("com.flyway.migrationoracle.repository")
@EntityScan("com.flyway.migrationoracle.entity")
@ComponentScan({ "com.flyway.migrationoracle.controller", "com.flyway.migrationoracle.service", "com.flyway.migrationoracle.service.impl"})
@EnableCaching
public class FlywayDbMigrationOracleApplication {
    public static void main(String[] args) {
        SpringApplication.run(FlywayDbMigrationOracleApplication.class, args);
    }

}

