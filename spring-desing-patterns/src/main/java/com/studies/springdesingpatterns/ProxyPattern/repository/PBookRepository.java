package com.studies.springdesingpatterns.ProxyPattern.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studies.springdesingpatterns.ProxyPattern.entity.PBookEntity;

public interface PBookRepository extends JpaRepository<PBookEntity, Integer> {

}
