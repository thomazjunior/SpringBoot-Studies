package com.springboot.studies.springsecurity;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class HomeController {
    private final LocationService locationService;

    public HomeController(LocationService locationService) {
        this.locationService = locationService;
    }

    // String greeting(Authentication auth) {
    @GetMapping
    String greeting(@CurrentSecurityContext(expression = "authentication.name") String name) {
        // Authentication authentication =
        // SecurityContextHolder.getContext().getAuthentication();

        // return "Hello World :) " + auth.getName();
        return "Hello world " + name;
    }

    @PostMapping("/location")
    public String changeLocation(Authentication authentication, @RequestBody String location) {

        return this.locationService.moveTo(location);
    }
}
