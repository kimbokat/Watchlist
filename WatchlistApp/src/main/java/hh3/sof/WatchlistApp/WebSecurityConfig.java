package hh3.sof.WatchlistApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration  
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {
	
		@Autowired
		private UserDetailsService userDetailsService;

		@Bean
	   public SecurityFilterChain configure(HttpSecurity http) throws Exception {
	       http
	       		.csrf().disable() // disabled CSRF for functional edit
	            .authorizeHttpRequests()
	            	.requestMatchers("/css/**").permitAll()
	            	.requestMatchers("/signup", "/save**").permitAll()
	            	.anyRequest().authenticated()
	            	.and()
	            .formLogin()
	            	.loginPage("/login")
	                .defaultSuccessUrl("/movielist", true)
	                .permitAll()
	                .and()
	            .logout()
	                .permitAll()
	                .invalidateHttpSession(true)
	                .and()
	            .httpBasic();
	            return http.build();
	      
	    		   
	    }
		
		@Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
		}

}