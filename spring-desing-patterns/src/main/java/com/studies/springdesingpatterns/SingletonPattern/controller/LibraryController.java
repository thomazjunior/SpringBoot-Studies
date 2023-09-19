
package com.studies.springdesingpatterns.SingletonPattern.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studies.springdesingpatterns.SingletonPattern.repository.BookRepository;


@RestController
@RequestMapping("")
public class LibraryController {
    @Autowired
    BookRepository bookRepository;

    @GetMapping
    Long getTotal() {
        System.out.println(bookRepository);
        return bookRepository.count();
    }
}
