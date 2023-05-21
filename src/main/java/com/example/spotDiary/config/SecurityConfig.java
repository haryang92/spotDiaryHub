package com.example.spotDiary.config;

import com.example.spotDiary.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

		private final CustomUserDetailsService customUserDetailsService;


		// 비밀번호 암호화 객체
		@Bean
		public BCryptPasswordEncoder encoder() {
				return new BCryptPasswordEncoder();
		}

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
				auth.userDetailsService(customUserDetailsService).passwordEncoder(encoder());
		}

		// 인증을 무시할 경로 설정
		@Override
		public void configure(WebSecurity web) throws Exception {
			web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
		}

		// HTTP 요청에 대한 보안을 구성
		@Override
		protected void configure(HttpSecurity http) throws Exception {
				http.csrf().disable()
								.authorizeRequests()
								.antMatchers("/", "/auth/**", "/posts/read/**", "/posts/search/**")
								.permitAll()
								.anyRequest()
								.authenticated()
								.and()
								.formLogin()
								.loginPage("/auth/views/login")
								.loginProcessingUrl("/")
								.defaultSuccessUrl("/")
								.and()
								.logout()
								.logoutSuccessUrl("/")
								.invalidateHttpSession(true);
		}


}
