package com.github.springquartz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
@Slf4j
public class SpringQuartzApplication implements CommandLineRunner {

    @Autowired
    private DataSource datasource;


    public static void main(String[] args) {
        SpringApplication.run(SpringQuartzApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info(datasource.toString());
    }
}
