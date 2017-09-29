package com.theironyard.charlotte.LotBot;

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

  public static Lot createLot(int price, int spots) {
    Lot l = new Lot();
    l.setPrice(price);
    l.setId(NUM_CREATED++);
    l.setSpaces(new Space[spots]);

    return l;
  }
}
