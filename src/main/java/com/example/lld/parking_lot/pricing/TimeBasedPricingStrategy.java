package com.example.lld.parking_lot.pricing;

import com.example.lld.parking_lot.Ticket;
import com.example.lld.parking_lot.constants.VehicleType;

import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TimeBasedPricingStrategy implements PricingContext {

    private static double BASE_BIKE_PRICE = 100;
    private static double BASE_CAR_PRICE = 200;
    private static double BASE_TRUCK_PRICE = 300;

    @Override
    public double getPrice(Ticket ticket) {

        VehicleType vehicleType = ticket.getVehicle().getVehicleType();
        double fare = 0;

        if(VehicleType.BIKE.equals(vehicleType)){
            fare = BASE_BIKE_PRICE;
        }

        else if(VehicleType.CAR.equals(vehicleType)){
            fare = BASE_CAR_PRICE;
        }

        else if(VehicleType.TRUCK.equals(vehicleType)){
            fare = BASE_TRUCK_PRICE;
        }

        if(fare == 0)
            throw new RuntimeException("No Pricing strategy set for vehicle type: " + vehicleType);

        return fare * getSurchargeFactor(ticket);
    }

    private double getSurchargeFactor(Ticket ticket){

        LocalTime inTime = ticket.getTicketIssuedAt().toLocalTime();

        LocalTime sixAM = LocalTime.of(6, 0);
        LocalTime fivePM = LocalTime.of(17, 0);

        // Between 6 AM and 5 PM
        boolean isDayTime = !inTime.isBefore(sixAM) && inTime.isBefore(fivePM);

        // Between 5 PM and next day 6 AM
        boolean isNightTime = inTime.isAfter(fivePM) || inTime.isBefore(sixAM);

        if(isNightTime)
            return 1.5;

        return 1;
    }

    public void overridePrice(double bikePrice, double carPrice, double truckPrice){

        if(bikePrice < 0 || carPrice < 0 || truckPrice < 0){
            throw new InvalidParameterException("Price cannot be less than 0");
        }

        BASE_BIKE_PRICE = bikePrice;
        BASE_CAR_PRICE = carPrice;
        BASE_TRUCK_PRICE = truckPrice;
    }
}
