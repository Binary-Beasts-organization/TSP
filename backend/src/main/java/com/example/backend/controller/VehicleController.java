package com.example.backend.controller;


import com.example.backend.exception.VehicleNotFoundException;
import com.example.backend.model.Vehicle;
import com.example.backend.repository.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin

public class VehicleController {
    @Autowired

    private VehicleRepo vehicleRepo;
    @PostMapping("/vehicle")
    Vehicle newVehicle(@RequestBody Vehicle newVehicle)
    {
        return vehicleRepo.save(newVehicle);//save new vehicle

    }
    @GetMapping("/vehicles")
    List<Vehicle> getAllVehicles(){
        return vehicleRepo.findAll(); //find all vehicles

    }
    @GetMapping("vehicle/{id}")
    Vehicle getVehicleById(@PathVariable Long id)
    {
        return vehicleRepo.findById(id).orElseThrow( //find a vehicle
                ()->new VehicleNotFoundException(id)//and error handling/
        );

    }
    @PutMapping("/vehicle/{id}")
    Vehicle updateVehicle(@RequestBody Vehicle newVehicle,@PathVariable Long id) {
        return vehicleRepo.findById(id).map(
                vehicle -> {
                    vehicle.setVehicleModel(newVehicle.getVehicleModel());
                    vehicle.setVehicleNumber(newVehicle.getVehicleNumber());
                    vehicle.setMaxPassengers(newVehicle.getMaxPassengers());
                    vehicle.setVehicleType(newVehicle.getVehicleType());
                    vehicle.setRating(newVehicle.getRating());
                    vehicle.setWorkingDistrict(newVehicle.getWorkingDistrict());
                    return vehicleRepo.save(vehicle);
                }).orElseThrow(() -> new VehicleNotFoundException(id));



    }

    @DeleteMapping("/user/{id}")
    String deleteVehicle(@PathVariable Long id){
        if(!vehicleRepo.existsById(id)){
            throw  new VehicleNotFoundException(id);//delete a vehicle


        }
        vehicleRepo.deleteById(id);
        return "User with id "+id+" has been deleted success";



    }


}

