package com.authorization;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;




@Configuration
public class SecurityConfiguration {
	
	 	
	    private String username="user";
	    
	    private String password="user";
	
	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        // Using NoOpPasswordEncoder for simplicity, you should use a stronger encoder in production
	        return NoOpPasswordEncoder.getInstance();
	    }

	    @Bean
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return authenticationManagerBean();
	    }

	    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf(csrf-> csrf.disable())
		 	.cors(cors-> cors.disable())
		 	.authorizeHttpRequests(auth-> auth.requestMatchers("/home/**")
		 			.authenticated()
		 			.requestMatchers("/auth/login")
		 			.permitAll()
		 			.requestMatchers("/auth/create")
		 			.permitAll()
		 			.anyRequest()
		 			.authenticated());
	            
	                
	    }

}
