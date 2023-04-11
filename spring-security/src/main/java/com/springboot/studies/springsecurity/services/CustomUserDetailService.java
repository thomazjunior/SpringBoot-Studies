package com.springboot.studies.springsecurity.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.studies.springsecurity.entities.User;
import com.springboot.studies.springsecurity.exceptions.UsernameAlreadyExistsException;
import com.springboot.studies.springsecurity.model.security.SecurityUser;
import com.springboot.studies.springsecurity.repositories.UserRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var u = userRepository.findByUsername(username);

        User user = u.orElseThrow(() -> new UsernameNotFoundException("user not found"));
       
        return new SecurityUser(user);
    }

    @Transactional
    public void createUser(User user) {
        var u = userRepository.findByUsername(user.getUsername());
        if (u.isPresent()) {
            throw new UsernameAlreadyExistsException();
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
