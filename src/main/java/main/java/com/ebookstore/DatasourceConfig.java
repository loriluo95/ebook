package main.java.com.ebookstore;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {
    @Bean
    public DataSource datasource() {
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/EBOOK?serverTimezone=UTC")
                .username("root")
                .password("pass")
                .build();
//        return DataSourceBuilder.create()
//                .driverClassName("com.mysql.jdbc.Driver")
//                .url("jdbc:mysql://b0008f21574269:40d3e5b7@us-cdbr-east-05.cleardb.net/heroku_7733fabc380c367?reconnect=true")
//                .username("b0008f21574269")
//                .password("40d3e5b7")
//                .build();
    }
}
