package com.spring.mastery.config;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebAppXmlInitializer /*implements WebApplicationInitializer*/ {
    /*@Override*/
    public void onStartup(ServletContext servletContext) throws ServletException {
        //xml config
        /*XmlWebApplicationContext context = new XmlWebApplicationContext();
        context.setConfigLocation("classpath:application-config.xml");*/

        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(AppConfiguration.class);

        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);

        ServletRegistration.Dynamic employeeCustomDispatcherServlet = servletContext.addServlet(" employeeServlet", dispatcherServlet);
        employeeCustomDispatcherServlet.setLoadOnStartup(1);
        employeeCustomDispatcherServlet.addMapping("/mastery.com/*");
    }
}
