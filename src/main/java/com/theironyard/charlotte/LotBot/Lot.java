package com.theironyard.charlotte.LotBot;

import java.util.Arrays;

public class Lot {
  private int id;
  static private int NUM_CREATED;
  private Space[] spaces;
  private double price;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Space[] getSpaces() {
    return spaces;
  }

  public void setSpaces(Space[] spaces) {
    this.spaces = spaces;
  }

  public Lot() {

  }

  public Lot(int id, Space[] spaces) {
    this.id = id;
    this.spaces = spaces;
  }

  public static int getNumCreated() {
    return NUM_CREATED;
  }

  public static void setNumCreated(int numCreated) {
    NUM_CREATED = numCreated;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Lot{" +
        "id=" + id +
        ", spaces=" + Arrays.toString(spaces) +
        ", price=" + price +
        '}';
  }

  public static Lot createLot(int price, int spots) { //Builds lot and puts cars in it.
    Lot l = new Lot();
    l.setPrice(price);
    l.setId(NUM_CREATED++);
    l.setSpaces(new Space[spots]);
    for (int i= 0; i< l.getSpaces().length; i++){
      l.getSpaces()[i] = new Space();
      if ( i % 3 == 0) {
        l.getSpaces()[i].setVehicle(new Car("acb-23" + i + "" + l.getId()));
      }
    }
    return l;
  }
}
