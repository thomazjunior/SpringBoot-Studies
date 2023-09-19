package com.studies.springdesingpatterns.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class MyFilter extends GenericFilterBean {
    @Autowired
    CustomAuthenticationManager authenticationManager;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       // HttpServletResponse response=(HttpServletResponse) servletResponse;
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        String name=request.getHeader("uname");
        String password=request.getHeader("password");
        CustomAuthentication customAuthentication=new CustomAuthentication(name,password,null);
        Authentication authentication=authenticationManager.authenticate(customAuthentication);//calling the authentication manager's authenticate() method and passing te authentication object as the parameter
        if(authentication.isAuthenticated())
        {
            SecurityContext securityContext= SecurityContextHolder.getContext();
            securityContext.setAuthentication(authentication);//adding the fully populated authentication object to the SecurityContext of the application.
            filterChain.doFilter(servletRequest,servletResponse);
        }

    }
}
