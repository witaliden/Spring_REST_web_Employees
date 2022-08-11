package com.spring.mastery.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan("com.spring.mastery")
@PropertySource("classpath:application.properties")
public class AppConfiguration {

    @Autowired
    Environment environment;
    ApplicationContext context;

    @Autowired
    public AppConfiguration(AnnotationConfigApplicationContext applicationContext){
        context = applicationContext;
    }

    //EmployeeDao employeeDao = context.getBean("EmployeeDao", EmployeeDao.class);

    private final String URL = "url";
    private final String USER = "user";
    private final String DRIVER = "driver";
    private final String PASSWORD = "password";

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(environment.getProperty(URL));
        driverManagerDataSource.setUsername(environment.getProperty(USER));
        driverManagerDataSource.setPassword(environment.getProperty(PASSWORD));
        driverManagerDataSource.setDriverClassName(environment.getProperty(DRIVER));
        return driverManagerDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }

    static class appInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

        @Override
        protected Class<?>[] getRootConfigClasses() {
            return new Class[0];
        }

        @Override
        protected Class<?>[] getServletConfigClasses() {
            return new Class[] {AppConfiguration.class};
        }

        @Override
        protected String[] getServletMappings() {
            return new String[] {"/"};
        }
    }
}
