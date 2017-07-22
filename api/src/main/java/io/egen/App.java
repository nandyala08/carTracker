package io.egen;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import io.egen.repository.GeoLocationRepository;
import io.egen.repository.GeoLocationRepositoryImpl;
import io.egen.repository.HighAlertRepository;
import io.egen.repository.HighAlertRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


import javax.sql.DataSource;
import java.util.List;

//--------------CORS Configuration-------------//
@Configuration
@EnableWebMvc
@ComponentScan
public class App extends WebMvcConfigurerAdapter{

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/*")
                .allowedOrigins("*").allowedMethods( "PUT", "POST", "GET", "OPTIONS","DELETE")
                .allowedHeaders("header1", "header2","header3")
                .exposedHeaders("header1","header2")
                .allowCredentials(false).maxAge(3600);
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        //MySQL database we are using
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/veh_db");//change url
        dataSource.setUsername("root");//change userid
        dataSource.setPassword("root");//change pwd

        //H2 database
        /*
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
        dataSource.setUsername("sa");
        dataSource.setPassword("");*/
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public HighAlertRepository highAlertRepository(){
        HighAlertRepository highAlertRepo = new HighAlertRepositoryImpl();
        highAlertRepo.setJdbcTemplate(jdbcTemplate());
        return highAlertRepo;
    }
//    @Bean
//    public GeoLocationRepository geoLocationRepository(){
//        GeoLocationRepository geoLocationRepo = new GeoLocationRepositoryImpl();
//        geoLocationRepo.setJdbcTemplate(jdbcTemplate());
//        return geoLocationRepo ;
//    }

}