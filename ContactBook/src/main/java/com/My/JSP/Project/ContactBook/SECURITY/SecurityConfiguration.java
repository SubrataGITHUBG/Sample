package com.My.JSP.Project.ContactBook.SECURITY;


import java.lang.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
    @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.inMemoryAuthentication()
		.withUser("admin")
		.password("password")
		.roles("ADMIN");
	}
    @Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.csrf().disable()                       //disble the default security
		.authorizeRequests()                       //allow the certin Http Authoritize request
		.antMatchers("/Contact").authenticated()   //allow only the contact url
		.anyRequest()                              //llow any type of reuest
		.permitAll()                               //permit for all
		.and() .httpBasic();                       //basis level request hndles in postman
		
	}
    
    //password encription and return an object(Authitication of password )
    
    @Bean
    public PasswordEncoder paswordEncoder()
    {
    	return NoOpPasswordEncoder.getInstance();
    }
	
}

