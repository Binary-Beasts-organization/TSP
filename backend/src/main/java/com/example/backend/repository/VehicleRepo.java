package com.example.backend.repository;

import com.example.backend.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepo extends JpaRepository<Vehicle,Long> {

}
