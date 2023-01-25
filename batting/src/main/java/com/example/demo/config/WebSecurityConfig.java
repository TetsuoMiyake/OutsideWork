package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;



	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//ログインページを指定。
		//ログインページへのアクセスは全員許可する。
		http.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/authenticate")
			.usernameParameter("userName")
			.passwordParameter("password")
			.defaultSuccessUrl("/hits")
			.permitAll();

		http.authorizeRequests()
			.antMatchers("/RegistrationForm").permitAll()
			.antMatchers("/Register").permitAll()
			.antMatchers("/Result").permitAll()
			.anyRequest().authenticated();

		http.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutUrl("/logoout")
			.logoutSuccessUrl("/login");
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder());
	}
}