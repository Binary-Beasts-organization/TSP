package com.example.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity

public class Vehicle {
  @Id
  @GeneratedValue


  private Long VehicleId;
  private String VehicleNumber;
  private String VehicleType;
  private String VehicleModel;
  private double rating;
  private int MaxPassengers;
  private String workingDistrict;

  public Long getVehicleId() {
    return VehicleId;
  }

  public void setVehicleId(Long vehicleId) {
    VehicleId = vehicleId;
  }

  public String getVehicleNumber() {
    return VehicleNumber;
  }

  public void setVehicleNumber(String vehicleNumber) {
    VehicleNumber = vehicleNumber;
  }

  public String getVehicleType() {
    return VehicleType;
  }

  public void setVehicleType(String vehicleType) {
    VehicleType = vehicleType;
  }

  public String getVehicleModel() {
    return VehicleModel;
  }

  public void setVehicleModel(String vehicleModel) {
    VehicleModel = vehicleModel;
  }

  public double getRating() {
    return rating;
  }

  public void setRating(double rating) {
    this.rating = rating;
  }

  public int getMaxPassengers() {
    return MaxPassengers;
  }

  public void setMaxPassengers(int maxPassengers) {
    MaxPassengers = maxPassengers;
  }

  public String getWorkingDistrict() {
    return workingDistrict;
  }

  public void setWorkingDistrict(String workingDistrict) {
    this.workingDistrict = workingDistrict;
  }
}
