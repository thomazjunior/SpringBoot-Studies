package com.studies.springdesingpatterns.config;

import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class CustomAuthenticationManager extends ProviderManager {
    public CustomAuthenticationManager(AuthenticationProvider... providers) {
        super(providers);
    }

    public CustomAuthenticationManager(List<AuthenticationProvider> providers) {
        super(providers);
    }

    public CustomAuthenticationManager(List<AuthenticationProvider> providers, AuthenticationManager parent) {
        super(providers, parent);
    }

    @Override
    public void afterPropertiesSet() {
        super.afterPropertiesSet();
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return super.authenticate(authentication);
    }

    @Override
    public List<AuthenticationProvider> getProviders() {
        return super.getProviders();
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        super.setMessageSource(messageSource);
    }

    @Override
    public void setAuthenticationEventPublisher(AuthenticationEventPublisher eventPublisher) {
        super.setAuthenticationEventPublisher(eventPublisher);
    }

    @Override
    public void setEraseCredentialsAfterAuthentication(boolean eraseSecretData) {
        super.setEraseCredentialsAfterAuthentication(eraseSecretData);
    }

    @Override
    public boolean isEraseCredentialsAfterAuthentication() {
        return super.isEraseCredentialsAfterAuthentication();
    }
}
