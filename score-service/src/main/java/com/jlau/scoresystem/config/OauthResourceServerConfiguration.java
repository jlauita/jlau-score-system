package com.jlau.scoresystem.config;

/**
 * Created by cxr1205628673 on 2020/9/17.
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;


/**
 * Created by cxr1205628673 on 2020/9/17.
 */
@Configuration
public class OauthResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        super.configure(resources);

    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/grade/add","/grade/save","/grade/delete","/grade/findall")
                .hasAnyRole("ADMIN","CADRE")
                .antMatchers("/activity/add","/activity/save","/activity/delete","/activity/findall")
                .hasAnyRole("ADMIN","OFFICE")
                .antMatchers("/apply/add","/apply/save","/apply/delete","/apply/findall")
                .hasAnyRole("ADMIN","OFFICE")
                .antMatchers("/grade/find/**","/activity/find","/apply/find")
                .permitAll()
                .anyRequest()
                .authenticated();
    }
}
