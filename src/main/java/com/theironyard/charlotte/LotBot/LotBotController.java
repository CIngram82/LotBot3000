package com.theironyard.charlotte.LotBot;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LotBotController {
  List<Lot> parkingLots = new ArrayList<>();

  public void postConstruct() {
    parkingLots.add(Lot.createLot(10,10));
    parkingLots.add(Lot.createLot(20,25));
    parkingLots.add(Lot.createLot(30,30));
    parkingLots.add(Lot.createLot(40,10));
    parkingLots.add(Lot.createLot(50,4));
  }

  //  GET   /lots         Get a list of all lots in the system, including # of spots.
  @CrossOrigin
  @RequestMapping(path = "/lots", method = RequestMethod.GET)
  private List<Lot> getAllLots(){
    postConstruct();

    return parkingLots;
  }


  //  GET   /lots/<id>    Get a list of the status of all spots in the specified lot,
  //                      including the license plate # of anyone parked.
  @CrossOrigin
  @RequestMapping(path = "/lots/{id}", method = RequestMethod.GET)
  private Space[] getSpaces(@PathVariable("id") int id){
    return parkingLots.get(id).getSpaces();
  }

  //  POST  /lots/<id>    Park a new car in the specified lot. Must send the Vehicle object
  //                      in the request body.

  @CrossOrigin
  @RequestMapping(path = "/lots/{id}/{index]",method = RequestMethod.POST)
  private void addCar(@RequestBody Car car, @PathVariable("index") int index, @PathVariable("id") int id){

    Space[] listSpaces= parkingLots.get(index).getSpaces();
    listSpaces[id].setVehicle(car);
  }
}

//  @CrossOrigin
//  @RequestMapping(path = "/books", method = RequestMethod.POST)
//  public void addBook(@RequestBody Book book) {
//    books.add(book);
//
//

//  The API
//  There are two key concepts that the entire Lot Bot system is based on: lots and cars. The API should support the following operations, and all should use JSON for encoding request and response bodies.
//
//

//Method  URL           Description





//  PUT   /lots/<id>/<spot>  Open up the specified spot and return the total owed.

//  GET   /transactions      Return a list of all transactions, along with the bill and
//                           license plate number of the charged vehicle.
