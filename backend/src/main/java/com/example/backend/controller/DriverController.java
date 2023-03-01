package com.example.backend.controller;

import com.example.backend.exception.DriverNotFoundException;
import com.example.backend.model.Driver;
import com.example.backend.repository.DriverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")

public class DriverController {
    @Autowired
    private DriverRepo driverRepo;


    @PostMapping("/driver")
    Driver newDriver(@RequestBody Driver newDriver) {
        return driverRepo.save(newDriver);

    }

    @GetMapping("/drivers")
    List<Driver> getAllDrivers() {
        return driverRepo.findAll();

    }


    @GetMapping("/driver/{id}")
    Driver getUserById(@PathVariable Long id) {
        return driverRepo.findById(id).orElseThrow
                (() -> new DriverNotFoundException(id));


    }

    @PutMapping("/user/{id}")
    Driver updateDriver(@RequestBody Driver newDriver, @PathVariable Long id) {
        return driverRepo.findById(id)
                .map(driver -> {
                    driver.setUserName(newDriver.getUserName());
                    driver.setName(newDriver.getName());
                    driver.setPassword(driver.getPassword());
                    driver.setPartTimeOrFullTime(driver.isPartTimeOrFullTime());
                    return driverRepo.save(driver);

                }).orElseThrow(() -> new DriverNotFoundException(id));


    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id) {
        if (!driverRepo.existsById(id)) {
            throw new DriverNotFoundException(id);

        }
        driverRepo.deleteById(id);
        return "User with id " + id + " has been deleted success";


    }
}
