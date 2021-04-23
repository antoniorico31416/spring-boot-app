package com.atom.springboot.web.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	//Import Implementation UserDetails
	private final UserDetailsImplementation userDetailsImplementation;
	
	@Autowired
	public SecurityConfig(UserDetailsImplementation userDetailsImplementation) {
		this.userDetailsImplementation = userDetailsImplementation;
	}
	
	//Use some encoder for passwords
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
		return passEncoder;
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsImplementation).passwordEncoder(passwordEncoder());
	}
	


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/","/auth/**","/app/**", "/css/**").permitAll().anyRequest().authenticated()
		
		.and().formLogin().loginPage("/auth/login").defaultSuccessUrl("/index",true).failureUrl("/auth/login?error=true")
			  .loginProcessingUrl("/auth/login").permitAll()
			  .and().logout().logoutUrl("/logout").logoutSuccessUrl("/index");

	}

}
