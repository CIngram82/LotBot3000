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
  private List<Lot> getAllLots() {
    postConstruct();
    return parkingLots;
  }


  @CrossOrigin
  @RequestMapping(path = "/lots/{id}", method = RequestMethod.GET)
  private Vehicle getSpaces(@PathVariable("id") int id) {
    System.out.println(parkingLots.get(id).getSpaces()[0].getVehicle());
    System.out.println(parkingLots.get(id).getSpaces()[1].getVehicle());
    System.out.println(parkingLots.get(id).getSpaces()[2].getVehicle());
    System.out.println(parkingLots.get(id).getSpaces()[3].getVehicle());

    return parkingLots.get(id).getSpaces()[0].getVehicle();
  }

  //  POST  /lots/<id>/<index>    Park a new car in the specified lot. Must send the Vehicle object
  //                      in the request body.

  @CrossOrigin
  @RequestMapping(path = "/lots/{id}/{index}", method = RequestMethod.POST)
  private void addCar(@RequestBody Vehicle car, @PathVariable("index") int index, @PathVariable("id") int id) {

    parkingLots.get(id).getSpaces()[index].setVehicle(car);
    transactionLog.add(Transaction.createTransaction(car, LocalDateTime.now(), parkingLots.get(id).getPrice()));
    System.out.println(transactionLog);
  }

  //  PUT   /lots/<id>/<spot>  Open up the specified spot and return the total owed.

  @CrossOrigin
  @RequestMapping(path = "/lots/{id}/{index}", method = RequestMethod.PUT)
  private void removeCar(@RequestBody Vehicle car, @PathVariable("index") int index, @PathVariable("id") int id) {
    double time = 0;
//    parkingLots.get(id).getSpaces()[index].setVehicle(null);
//    for (int i = 0; i < transactionLog.size(); i++) {
//      Transaction t = transactionLog.get(i);
//      if (t.getVehicle().getLicensePlate() == car.getLicensePlate() && t.getCheckedOutDate() == null) {
//        time = DateHelper.getHoursBetweenDates(t.getCheckedInDate(), t.getCheckedOutDate());
//      }
//    }
//    System.out.println(time);
  }
}


//  The API
//  There are two key concepts that the entire Lot Bot system is based on: lots and cars. The API should support the following operations, and all should use JSON for encoding request and response bodies.
//
//

//Method  URL           Description

//  GET   /transactions      Return a list of all transactions, along with the bill and
//                           license plate number of the charged vehicle.
