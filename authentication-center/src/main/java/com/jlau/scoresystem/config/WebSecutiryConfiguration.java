package com.jlau.scoresystem.config;

import com.jlau.scoresystem.dao.PrivilegeUserMapper;
import com.jlau.scoresystem.model.PrivilegeUser;
import org.apache.http.auth.AUTH;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by cxr1205628673 on 2020/9/16.
 */
@Configuration
public class WebSecutiryConfiguration extends WebSecurityConfigurerAdapter{
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    PrivilegeUserMapper privilegeUserMapper;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.inMemoryAuthentication().withUser("12172115").password(passwordEncoder.encode("xxx2435326")).roles("ADMIN");
        auth.userDetailsService(userDetailsService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/user/info")
                .permitAll()
                .antMatchers("/client/register")
                .permitAll()
                .anyRequest()
                .authenticated();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
                PrivilegeUser privilegeUser = privilegeUserMapper.findPrivilegeUserById(Integer.valueOf(s));
                if(privilegeUser == null){
                    throw new UsernameNotFoundException("找不到该用户");
                }
                return privilegeUser;
            }
        };
    }
}
