package com.example.backend.exception;

import com.example.backend.model.Vehicle;

public class VehicleNotFoundException extends RuntimeException{
    public VehicleNotFoundException(Long id){
        super("Could not found the user with id"+id);//exception

    }

}
