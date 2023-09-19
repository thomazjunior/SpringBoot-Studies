package com.studies.springdesingpatterns.ProxyPattern.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studies.springdesingpatterns.ProxyPattern.repository.PBookRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/pbook")
public class PBookController {

    // We can create separate instances of the BookRepository bean by changing the
    // bean scope from singleton to prototype using the
    // @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) annotation

    @Autowired
    PBookRepository bookRepository;

    @GetMapping
    @Transactional
    String getBookNames() {
        System.out.println(bookRepository);
        return "book.name";
    }
}
