package com.studies.springdesingpatterns.FactoryPattern;

import java.time.LocalDate;

public class Vehicle {
    private String name; 
    private String brand;
    private LocalDate release;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public LocalDate getRelease() {
        return release;
    }
    public void setRelease(LocalDate release) {
        this.release = release;
    } 
}
