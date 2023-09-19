package com.studies.springdesingpatterns.config;

import java.util.Collection;
import java.util.LinkedList;

import javax.security.auth.Subject;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class CustomAuthentication implements Authentication {

    String uname;
    String password;
    boolean authenticated;
    Collection<? extends GrantedAuthority> authorities=new LinkedList<>();
    public CustomAuthentication(String name,String password, Collection<? extends GrantedAuthority> authorities) {
        this.password=password;
        this.uname=name;
        this.authorities=authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public boolean implies(Subject subject) {
        return Authentication.super.implies(subject);
    }

    @Override
    public Object getCredentials() {
        return this.password;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.uname;
    }

    @Override
    public boolean isAuthenticated() {
        return this.authenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.authenticated=isAuthenticated;
    }

    @Override
    public String getName() {
        return null;
    }
}