package com.vignesh.springboot_playground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.vignesh.springboot_playground.service.CustomAuthenticationProvider;

@Configuration
@EnableWebSecurity(debug = false)
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomAuthenticationProvider authService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authService);
//		auth.userDetailsService(userDetailsService)
	}
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.requiresChannel().antMatchers("/**").requiresSecure()
		.and()
		.csrf().disable()
		.authorizeRequests()
//		.antMatchers("/hello").permitAll()
		.antMatchers("/login*").permitAll()
		.antMatchers("/person").permitAll()
		.antMatchers("/**").hasAnyRole("USER")
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/home")
		.failureUrl("/login?err=true")
		.permitAll()
		.and()
		.logout()
		.logoutUrl("/logout")
		.invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutSuccessUrl("/login?logout=true")
		.permitAll();
	}

}
