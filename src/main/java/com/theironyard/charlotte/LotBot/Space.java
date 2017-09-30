package com.theironyard.charlotte.LotBot;

public class Space {
  private Vehicle vehicle;

  @Override
  public String toString() {
    return "Space{" +
        "vehicle=" + vehicle +
        '}';
  }

  public Space(Vehicle vehicle) {
    this.vehicle = vehicle;
  }

  public Space() {
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public void setVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
  }
}
//Space
//		vehicle: vehicle
