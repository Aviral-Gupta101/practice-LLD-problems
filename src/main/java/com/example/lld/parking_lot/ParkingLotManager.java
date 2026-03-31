package com.example.lld.parking_lot;

import com.example.lld.parking_lot.cars.AbstractVehicle;
import com.example.lld.parking_lot.pricing.PricingContext;

public class ParkingLotManager {

    private final ParkingLot parkingLot;
    private final PricingContext pricingContext;

    public ParkingLotManager(ParkingLot parkingLot, PricingContext pricingContext) {
        this.parkingLot = parkingLot;
        this.pricingContext = pricingContext;
    }

    public Ticket parkCar(AbstractVehicle vehicle){

        Ticket ticket = null;

        boolean parkCarResult = parkingLot.parkCar(vehicle);

        if(parkCarResult){
            ticket = new Ticket(vehicle);
        }

        if(ticket == null)
            System.out.println("Unable to park car");

        return ticket;
    }

    public double exitVehicleAndGetPrice(Ticket ticket){

        boolean result = parkingLot.vacantCar(ticket.getVehicle());

        if(result){
            return pricingContext.getPrice(ticket);
        }

        System.out.println("Car not parked !!!");
        return 0;
    }

}
