package com.dawnlee.crud01.Config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource dataSource(){

        return new DruidDataSource();

    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean(){

        ServletRegistrationBean<StatViewServlet> statViewServletServletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        Map<String,String> init = new HashMap<>();

        init.put("loginUsername","admin");
        init.put("loginPassword","admin");
        init.put("allow","127.0.0.1");
        init.put("deny","22.22.22.22");


        return statViewServletServletRegistrationBean;

    }
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){

        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();


        filterFilterRegistrationBean.setFilter(new WebStatFilter());

        filterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));


        Map<String,String> init = new HashMap<>();


        init.put("exclusions","*.js,*.css,/druid/*");


        filterFilterRegistrationBean.setInitParameters(init);
        return filterFilterRegistrationBean;
    }

}
