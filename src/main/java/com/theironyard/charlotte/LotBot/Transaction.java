package com.theironyard.charlotte.LotBot;

import java.time.LocalDateTime;

public class Transaction {
  private int id;
  private static int ID_COUNTER;
  private Vehicle Vehicle;
  private LocalDateTime checkedInDate;
  private LocalDateTime checkedOutDate;
  private double price;

  public Vehicle getVehicle() {
    return Vehicle;
  }

  public void setVehicle(Vehicle vehicle) {
    this.Vehicle = vehicle;
  }

  public LocalDateTime getCheckedInDate() {
    return checkedInDate;
  }

  public void setCheckedInDate(LocalDateTime checkedInDate) {
    this.checkedInDate = checkedInDate;
  }

  public LocalDateTime getCheckedOutDate() {
    return checkedOutDate;
  }

  public void setCheckedOutDate(LocalDateTime checkedOutDate) {
    this.checkedOutDate = checkedOutDate;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public Transaction() {

  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public static Transaction createTransaction(Vehicle Vehicle, LocalDateTime checkedInDate, double price) {
    Transaction t = new Transaction();
    t.setVehicle(Vehicle);
    t.setCheckedInDate(checkedInDate);
    t.setPrice(price);
    t.setId(ID_COUNTER);
    ID_COUNTER++;
    return t;
  }
}
