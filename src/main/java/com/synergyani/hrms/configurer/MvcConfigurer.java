/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergyani.hrms.configurer;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author Dell
 */
@Configuration
public class MvcConfigurer extends WebMvcConfigurerAdapter {
     @Override
    public void configureViewResolvers(ViewResolverRegistry registry){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        registry.viewResolver(resolver);
    }
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
    
//     @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//     
//        registry.addViewController("/login").setViewName("login");
//         
//    }
    
     @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry
          .addResourceHandler("/webjars/**","/resources/**")
          .addResourceLocations("/webjars/","/resources/");
    }
}
