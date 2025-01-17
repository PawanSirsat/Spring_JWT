package net.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import net.springboot.security.JwtAuthenticationEntryPoint;
import net.springboot.security.JwtAuthenticationFilter;
import net.springboot.service.CustomerUserDetailService;


@Configuration
@EnableWebSecurity
public class SecurityConfig {


	@Autowired
    private CustomerUserDetailService customerUserDetailService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
    private JwtAuthenticationEntryPoint point;
	
    @Autowired
    private JwtAuthenticationFilter filter;
   

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/v1/employees/**").permitAll()
                        .requestMatchers("/auth/login").permitAll()
                        .requestMatchers("/auth/create-user").permitAll()
                        .anyRequest().authenticated())
                .exceptionHandling(ex -> ex.authenticationEntryPoint(point))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public LogoutHandler logoutHandler() {
        return (request, response, authentication) -> {
            // Clear the session cookies
            request.getSession().invalidate();

            // Clear any other session data here
        };
    }
    
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
	DaoAuthenticationProvider Provider = new DaoAuthenticationProvider();
	Provider.setUserDetailsService(customerUserDetailService);
	Provider.setPasswordEncoder(passwordEncoder);
	
	return Provider;
}

    @Bean
    public AuthenticationManager authenticationManagerSecurityConfig(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }

}