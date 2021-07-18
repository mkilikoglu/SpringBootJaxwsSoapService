package com.springbootjaxwssoapservice;

import com.sun.xml.ws.transport.http.servlet.WSSpringServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import javax.servlet.Servlet;
import java.util.Iterator;
import java.util.LinkedHashSet;

@SpringBootApplication
@ImportResource(locations = {"classpath*:jaxwsconfig.xml"})

public class SpringBootJaxwsSoapServiceApplication {

    public static void main(String[] args) {
        try{
            SpringApplication.run(SpringBootJaxwsSoapServiceApplication.class, args);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
      
    }
    @Bean
    public Servlet jaxwsServlet() {
        return new WSSpringServlet();
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {

        LinkedHashSet<String> set=new LinkedHashSet();
        set.add("/service/calculator");
        set.add("/service/calculator2");
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setUrlMappings(set);
        servletRegistrationBean.setServlet(jaxwsServlet());
        return servletRegistrationBean;
    }




}
