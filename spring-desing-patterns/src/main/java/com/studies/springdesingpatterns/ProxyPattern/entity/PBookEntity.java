package com.studies.springdesingpatterns.ProxyPattern.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "book")
@Getter
@Setter
public class PBookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usid;
    private String title;
    private String author;
    
}