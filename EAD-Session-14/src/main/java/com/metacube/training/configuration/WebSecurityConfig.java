package com.metacube.training.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration 
@EnableWebMvcSecurity 
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
    @Autowired							
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    // DB Authentication
    	auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username, password, enable from User where username=?")
		.authoritiesByUsernameQuery("select username, role from UserRole where username=?");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    // Http Basic, Form Based, Remember Me	
    	http
    	.authorizeRequests()
    	.antMatchers("/admin/*").access("hasRole('ADMIN')")
    	.antMatchers("/user/*").access("hasRole('USER')")
    	.and()
	    	.formLogin()
	    	.loginPage("/login") 
	        .loginProcessingUrl("/Login") 
	        .defaultSuccessUrl("/login/home")
	        .usernameParameter("username")
	        .passwordParameter("password")
	        .failureUrl("/error")
        .and()
			.logout().logoutSuccessUrl("/login?logout")
			.logoutUrl("/Logout")
		.and()
			.csrf();
    }
}