package com.example.backend.repository;

import com.example.backend.model.Driver;
import com.example.backend.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepo extends JpaRepository<Driver,Long> {

}
