package com.antiamazon.vendeur1.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Autowired
    Environment environment;

    @Value("${prod.spring.datasource.url}")
    private String prodDbUrl;

    @Value("${modeDevLocal}")
    private boolean isDev;


    @Bean
    public DataSource dataSource() {
        if(isDev){
            final DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName(environment.getProperty("driverClassName"));
            dataSource.setUrl(environment.getProperty("url"));
            dataSource.setUsername(environment.getProperty("user"));
            dataSource.setPassword(environment.getProperty("password"));
            return dataSource;
        } else {
            HikariConfig config = new HikariConfig();
            prodDbUrl = environment.getProperty("prod.spring.datasource.url");
            config.setJdbcUrl(prodDbUrl);
            return new HikariDataSource(config);

            //URI dbUri = new URI(prodDbUrl);
            //String username = dbUri.getUserInfo().split(":")[0];
            //String password = dbUri.getUserInfo().split(":")[1];
            //String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
            //return DriverManager.getConnection(dbUrl, username, password);
        }
    }

}
