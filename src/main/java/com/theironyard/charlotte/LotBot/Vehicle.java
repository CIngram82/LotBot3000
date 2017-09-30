package com.theironyard.charlotte.LotBot;

public class Vehicle {
  private String licensePlate;

  public Vehicle(String licensePlate) {
    this.licensePlate = licensePlate;
  }

  public Vehicle() {
  }

  public String getLicensePlate() {
    return licensePlate;
  }

  @Override
  public String toString() {
    return "Vehicle{" +
        "licensePlate='" + licensePlate + '\'' +
        '}';
  }

  public void setLicensePlate(String licensePlate) {
    this.licensePlate = licensePlate;
  }
}
//Vehicle
//		licensePlate: String
