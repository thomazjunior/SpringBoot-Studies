
package com.studies.springdesingpatterns.ProxyPattern.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studies.springdesingpatterns.ProxyPattern.repository.PBookRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("p")
public class PLibraryController {
    // When using @transactional, Spring creates a proxy that wraps our repository
    // and instruments our bean to execute our method automatically, inside as
    // EnhancerBySpringCGLIB

    /**
     * Generally, Spring uses two types of proxies:
     * 
     * CGLib Proxies – Used when proxying classes
     * JDK Dynamic Proxies – Used when proxying interfaces
     */

    @Autowired
    PBookRepository pbookRepository;

    @GetMapping
    @Transactional
    Long getTotal() {
        System.out.println(pbookRepository.getClass().getName());
        return pbookRepository.count();
    }
}
