package com.example.backend.controller;

import com.example.backend.exception.PassengerNotFoundAdvice;
import com.example.backend.exception.PassengerNotFoundException;
import com.example.backend.model.Passenger;
import com.example.backend.repository.PassengerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@CrossOrigin("http://localhost:3000")
public class PassengerController {
    @Autowired
    private PassengerRepo passengerRepo;

    @PostMapping("/passenger")
    Passenger newPassenger(@RequestBody Passenger newPassenger) {
        return passengerRepo.save(newPassenger);//save  new passenger


    }

    @GetMapping("/passengers")
    List<Passenger> getAllPassengers() {
        return passengerRepo.findAll();//find All passengers

    }

    @GetMapping("/passenger/{id}")
    Passenger getPassengerById(@PathVariable Long id) {
        return passengerRepo.findById(id).orElseThrow(() -> new PassengerNotFoundException(id));//get passenger by id


    }

    @PutMapping("/Passenger/{id}")
    Passenger updatePassenger(@RequestBody Passenger newPassenger, @PathVariable Long id) {
        return passengerRepo.findById(id)
                .map(passenger -> {
                    passenger.setUsername(newPassenger.getUsername());
                    passenger.setName(newPassenger.getName());
                    passenger.setEmail(newPassenger.getEmail());
                    return passengerRepo.save(passenger);//save passenger

                }).orElseThrow(() -> new PassengerNotFoundException(id));

    }

    @DeleteMapping("/passenger/{id}")
    String deleteUser(@PathVariable Long id) {
        if (!passengerRepo.existsById(id)) {
            throw new PassengerNotFoundException(id);//error handling

        }
        passengerRepo.deleteById(id);
        return "Passenger with id "+id+" has been deleted";//delete a passenger by id


    }

}







