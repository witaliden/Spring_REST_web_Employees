package com.spring.mastery.config;

import com.spring.mastery.rest.EmployeeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableWebMvc
@ComponentScan("com.spring.mastery")
@PropertySource("classpath:application.properties")
public class AppConfiguration implements WebMvcConfigurer {

    @Autowired
    Environment environment;
    ApplicationContext context;

    @Autowired
    public AppConfiguration(AnnotationConfigApplicationContext applicationContext) {

        context = applicationContext;
    }

    @Autowired
    EmployeeController controller = context.getBean("EmployeeController", EmployeeController.class);


    @Bean
    DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        String URL = "url";
        driverManagerDataSource.setUrl(environment.getProperty(URL));
        String USER = "user";
        driverManagerDataSource.setUsername(environment.getProperty(USER));
        String PASSWORD = "password";
        driverManagerDataSource.setPassword(environment.getProperty(PASSWORD));
        String DRIVER = "driver";
        driverManagerDataSource.setDriverClassName(Objects.requireNonNull(environment.getProperty(DRIVER)));
        return driverManagerDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    static class appInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

        @Override
        protected Class<?>[] getRootConfigClasses() {
            return new Class[0];
        }

        @Override
        protected Class<?>[] getServletConfigClasses() {
            return new Class[]{AppConfiguration.class};
        }

        @Override
        protected String[] getServletMappings() {
            return new String[]{"/"};
        }
    }
}
