package com.example.backend.exception;

public class DriverNotFoundException extends RuntimeException {
    public DriverNotFoundException(Long id) {
        super("Could not found the driver with id "+id);//error handling
    }

}
