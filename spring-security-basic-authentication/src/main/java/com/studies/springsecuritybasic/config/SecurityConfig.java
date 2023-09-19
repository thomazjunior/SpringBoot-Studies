package com.studies.springdesingpatterns.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder getPaswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public CustomUserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .addFilterAfter(getMyFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests(requests -> requests
                        .anyRequest()
                        .authenticated())
                .httpBasic(withDefaults())
                .build();
    }

    @Bean
    public MyFilter getMyFilter() throws Exception {
        return new MyFilter();
    }

    @Bean
    public CustomAuthenticationManager authenticationManager()
            throws Exception {
        CustomAuthenticationManager authenticationManager = new CustomAuthenticationManager(
                customAuthenticationProvider());
        return authenticationManager;

    }

    @Bean
    public AuthenticationProvider customAuthenticationProvider() {
        return new CustomAuthenticationProvider();
    }

}