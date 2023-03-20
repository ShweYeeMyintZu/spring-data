package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Bean
    public DataSource dataSource(){
        return new EmbeddedDatabaseBuilder()
                .addScript("schema.sql")
                .setScriptEncoding("utf-8")
                .build();
    }
}
