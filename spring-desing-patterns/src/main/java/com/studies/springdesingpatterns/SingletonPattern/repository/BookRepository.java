package com.studies.springdesingpatterns.SingletonPattern.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studies.springdesingpatterns.SingletonPattern.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {

}
