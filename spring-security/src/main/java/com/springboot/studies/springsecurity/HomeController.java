package com.springboot.studies.springsecurity;

import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class HomeController {
    // String greeting(Authentication auth) {
    @GetMapping
    String greeting(@CurrentSecurityContext(expression = "authentication.name") String name) {
        // Authentication authentication =
        // SecurityContextHolder.getContext().getAuthentication();

        // return "Hello World :) " + auth.getName();
        return "Hello world " + name;
    }
}
