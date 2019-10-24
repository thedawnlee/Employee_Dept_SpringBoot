package com.dawnlee.crud01.Config;

import com.dawnlee.crud01.Component.MylocaleResolver;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//@Configuration
//public class MyMvcConfig extends WebMvcConfigurationSupport {
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        //super.addViewControllers(registry);
//
//        registry.addViewController("/").setViewName("login");
//    }
//    @Bean
//    public WebMvcConfigurationSupport webMvcConfigurationSupport(){
//        WebMvcConfigurationSupport webMvcConfigurationSupport = new WebMvcConfigurationSupport(){
//            @Override
//            public void addViewControllers(ViewControllerRegistry registry) {
////                super.addViewControllers(registry);
//                registry.addViewController("/").setViewName("login");
//                registry.addViewController("/login.html").setViewName("login");
//            }
//        };
//        return webMvcConfigurationSupport;
//
//    }
//}

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {



    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {



        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {


            @Override
            public void addViewControllers(ViewControllerRegistry registry) {

                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }
        };

        return adapter;
    }
    @Bean
    public LocaleResolver localeResolver(){

        return new MylocaleResolver();
    }
}
