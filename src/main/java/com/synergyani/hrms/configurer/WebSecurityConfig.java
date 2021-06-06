/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synergyani.hrms.configurer;

import com.synergyani.hrms.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.UserDetailsService;
/**
 *
 * @author Dell
 */
@Configuration
@EnableWebSecurity
@ComponentScan("org.springframework.security.samples.mvc")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }
     
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
    
    @Bean
    public MyPasswordEncoder passwordEncoder() {
        return new MyPasswordEncoder();
    }
   
     
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
         
        return authProvider;
    }
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // this is imp in jsp.
            .authorizeRequests()
            
            .antMatchers("/webjars/**", "/resources/**").permitAll()
            .antMatchers("/").hasAnyAuthority("USER", "ADMIN")
            .antMatchers("/user").hasAnyAuthority("USER", "ADMIN")
            .antMatchers("/user/new").hasAuthority("ADMIN")
            .antMatchers("/user/edit/**").hasAuthority("ADMIN")
            .antMatchers("/user/delete/**").hasAuthority("ADMIN")
            .antMatchers("/employee/newemployee").hasAnyAuthority("USER","ADMIN")
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .permitAll()
            .defaultSuccessUrl("/", true)
            .and()
            .logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login")
            .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID")
            .and()
            .exceptionHandling().accessDeniedPage("/403")
            ;
    }
}
