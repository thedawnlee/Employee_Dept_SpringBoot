//package com.dawnlee.crud01.Config;
//
//
//import com.dawnlee.crud01.Handller.MyHandllerInterceptors;
//import com.sun.org.apache.regexp.internal.RE;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class MyMvcConfig_role implements WebMvcConfigurer {
//
//
//
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//
//
//            registry.addViewController("/").setViewName("login");
//            registry.addViewController("/main.html").setViewName("dashboard");
//
//
//    }
//
//    @Bean
//   public WebMvcConfigurer webMvcConfigurer(){
//
//       WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer(){
//
//           @Override
//           public void addViewControllers(ViewControllerRegistry registry) {
//
//               registry.addViewController("/").setViewName("login");
//               registry.addViewController("/index.html").setViewName("login");
//               registry.addViewController("/main.html").setViewName("dashboard");
//           }
//
////           @Override
////           public void addInterceptors(InterceptorRegistry registry) {
////               registry.addInterceptor(new MyHandllerInterceptors()).addPathPatterns("/**").excludePathPatterns("/","/index.html","/user/login","/webjars/**");
////           }
//       };
//return webMvcConfigurer;
//   }
//
//}