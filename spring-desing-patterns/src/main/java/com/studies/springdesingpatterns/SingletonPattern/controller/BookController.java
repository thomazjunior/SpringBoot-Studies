package com.studies.springdesingpatterns.SingletonPattern.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studies.springdesingpatterns.SingletonPattern.repository.BookRepository;

@RestController
@RequestMapping("/book")
public class BookController {

    // We can create separate instances of the BookRepository bean by changing the
    // bean scope from singleton to prototype using the
    // @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) annotation

    @Autowired
    BookRepository bookRepository;

    @GetMapping
    String getBookNames() {
        System.out.println(bookRepository);
        return "book.name";
    }
}
