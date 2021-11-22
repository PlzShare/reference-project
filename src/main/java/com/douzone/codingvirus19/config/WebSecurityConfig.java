package com.douzone.codingvirus19.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.douzone.codingvirus19.security.LoginSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().cors();

		http.authorizeRequests().antMatchers("/assets/**").permitAll().antMatchers("/auth/admin/**").hasRole("ADMIN")
				.antMatchers("/auth/**").hasAnyRole("ADMIN", "USER") // 내부적으로 접두어 "ROLE_"가 붙는다.
				.anyRequest().authenticated();

		http.formLogin().loginPage("/") // default
				.loginProcessingUrl("/user/auth").failureUrl("/error/?error") // default
//				.successHandler(new LoginSuccessHandler())
				.defaultSuccessUrl("/?login", true) // 로그인 성공시
				.usernameParameter("id").passwordParameter("password").permitAll();

		http.logout().logoutUrl("/logout") // default
				.logoutSuccessUrl("/").permitAll();

	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 사용자 세부 서비스를 설정하기 위한 오버라이딩이다.
		auth.userDetailsService(userDetailsService);
	}

}
