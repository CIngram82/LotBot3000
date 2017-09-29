package com.theironyard.charlotte.LotBot;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class LotBotController {
  List<Lot> parkingLots = new ArrayList<>();
  List<Transaction> transactionLog = new ArrayList<>();

  public void postConstruct() {
    if (parkingLots.size() < 1) {
      parkingLots.add(Lot.createLot(10, 10));
      parkingLots.add(Lot.createLot(20, 25));
      parkingLots.add(Lot.createLot(30, 30));
      parkingLots.add(Lot.createLot(40, 10));
      parkingLots.add(Lot.createLot(50, 4));
    }
  }

  @CrossOrigin
  @RequestMapping(path = "/lots", method = RequestMethod.GET)
  private List<Lot> getAllLots(){
    postConstruct();
    return parkingLots;
  }


  @CrossOrigin
  @RequestMapping(path = "/lots/{id}", method = RequestMethod.GET)
  private Lot getSpaces(@PathVariable("id") int id){
    return parkingLots.get(id);
  }

  //  POST  /lots/<id>/<index>    Park a new car in the specified lot. Must send the Vehicle object
  //                      in the request body.

  @CrossOrigin
  @RequestMapping(path = "/lots/{id}/{index]",method = RequestMethod.POST)
  private void addCar(@RequestBody Car car, @PathVariable("index") int index, @PathVariable("id") int id){

    Space[] listSpaces= parkingLots.get(id).getSpaces();
    listSpaces[index].setVehicle(car);
    transactionLog.add(Transaction.createTransaction(car, LocalDateTime.now(), parkingLots.get(id).getPrice()));
  }

//  PUT   /lots/<id>/<spot>  Open up the specified spot and return the total owed.
  @CrossOrigin
  @RequestMapping(path = "/lots/{id}/{index]",method = RequestMethod.PUT)
  private void removeCar(@RequestBody Car car, @PathVariable("index") int index, @PathVariable("id") int id){

   Space[] listSpaces= parkingLots.get(index).getSpaces();
    listSpaces[id].setVehicle(car);
}
}



//  The API
//  There are two key concepts that the entire Lot Bot system is based on: lots and cars. The API should support the following operations, and all should use JSON for encoding request and response bodies.
//
//

//Method  URL           Description

//  GET   /transactions      Return a list of all transactions, along with the bill and
//                           license plate number of the charged vehicle.
