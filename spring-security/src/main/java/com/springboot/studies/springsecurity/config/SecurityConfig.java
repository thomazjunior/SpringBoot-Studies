package com.springboot.studies.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // authentication
        // http.httpBasic().realmName("my_realm");
        http.httpBasic().realmName("real_name").and().formLogin();

        // autorization
        http.authorizeHttpRequests()
                .antMatchers("/user").permitAll()
                .antMatchers("/admin").hasAuthority("read")
                //.antMatchers("/smth").access(new WebExpressionAuthorizationManager("isAuthenticated")) only after 5.8 version
                .anyRequest().authenticated();
        http.csrf(csrf -> csrf.ignoringAntMatchers("/user"));

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // public static class CustomJwtGrantedAuthoritiesConverter implements
    // Converter<Jwt, Collection<GrantedAuthority>> {
    // JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new
    // JwtGrantedAuthoritiesConverter();

    // @Override
    // public Collection<GrantedAuthority> convert(Jwt jwt) {
    // Collection<GrantedAuthority> grantedAuthorities =
    // jwtGrantedAuthoritiesConverter.convert(jwt);
    // Collection<String> scopes = jwt.getClaim("scope");
    // if (scopes.contains("aircraft.fly") || scopes.contains("boat.sail")) {
    // grantedAuthorities.add(new SimpleGrantedAuthority("captain"));
    // }
    // return grantedAuthorities;
    // }
    // }

}
