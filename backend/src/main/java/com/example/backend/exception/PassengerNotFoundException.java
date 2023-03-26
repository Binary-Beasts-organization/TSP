package com.example.backend.exception;


public class PassengerNotFoundException extends RuntimeException{
    public PassengerNotFoundException(Long id){
        super("Could not found the passenger with id"+id);//passenger not found error
    }
}
