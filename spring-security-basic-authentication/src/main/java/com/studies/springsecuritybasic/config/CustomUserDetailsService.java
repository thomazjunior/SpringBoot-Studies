package com.studies.springdesingpatterns.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        if (userName.equals("surya")) {
            return User.withUsername("surya").password("12345").authorities("read").build();
        } else {
            throw new UsernameNotFoundException("name not found");
        }
    }

}
