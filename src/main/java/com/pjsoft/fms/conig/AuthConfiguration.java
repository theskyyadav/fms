package com.pjsoft.fms.conig;

import com.pjsoft.fms.service.AuthUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration

@EnableWebSecurity

@EnableMethodSecurity

public class AuthConfiguration {

    @Autowired

    private JwtAuthFilter authFilter;

    @Autowired

    private AuthUserDetailsService authUserDetailsService;

    @Bean

    public
    PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder(10);

    }

    @Bean

    public
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http

                .csrf(csrf -> csrf.disable()).headers(headers -> headers.frameOptions().sameOrigin())  // Disable CSRF

                .authorizeHttpRequests(auth -> auth

                        .requestMatchers("api/user/** ","/api/user/login", "/api/user/register", "/h2-console/**").permitAll() // Public endpoints

                        .anyRequest().authenticated() // Secure all other endpoints

                )

                .sessionManagement(session -> session

                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Stateless session management

                )

                .authenticationProvider(authenticationProvider()) // Your authentication provider

                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class); // Add your custom filter

        return http.build();

    }

    @Bean

    public
    AuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();

        authenticationProvider.setUserDetailsService(authUserDetailsService);

        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return authenticationProvider;

    }

    @Bean

    public
    AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {

        return config.getAuthenticationManager();

    }

}

 