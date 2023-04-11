package com.springboot.studies.springsecurity.exceptions;

public class UsernameAlreadyExistsException extends RuntimeException{
    public UsernameAlreadyExistsException() {
        super("Username already exists");
    }
}
