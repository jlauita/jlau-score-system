package com.jlau.scoresystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.web.client.RestTemplate;

/**
 * Created by cxr1205628673 on 2020/9/20.
 */
@Configuration
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter{
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/user/privilegeuser/add","/user/privilegeuser/save","/user/privilegeuser/delete/**",
                        "/user/privilegeuser/findall")
                .hasRole("ADMIN")
                .antMatchers("/user/student/findall","/user/student/add","/user/student/save","/user/student/delete/**")
                .hasRole("ADMIN")
                .antMatchers("/user/student/login","/user/privilegeuser/login","/user/student/callback")
                .permitAll()
                .anyRequest()
                .authenticated();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        super.configure(resources);
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
