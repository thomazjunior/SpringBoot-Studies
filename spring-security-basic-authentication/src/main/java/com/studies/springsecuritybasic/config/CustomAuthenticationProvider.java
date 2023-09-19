package com.studies.springdesingpatterns.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    CustomUserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = (String) authentication.getPrincipal();
        UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
        if (authentication.getCredentials().equals(userDetails.getPassword())) {
            CustomAuthentication customAuthentication = new CustomAuthentication(userDetails.getUsername(),
                    userDetails.getPassword(), userDetails.getAuthorities());
            customAuthentication.setAuthenticated(true);
            return customAuthentication;
        } else {
            throw new BadCredentialsException("please dont try to hack");
        }
    }

    @Override
        public boolean supports(Class<?> authentication){
            return CustomAuthentication.class.equals(authentication);
        }
}
