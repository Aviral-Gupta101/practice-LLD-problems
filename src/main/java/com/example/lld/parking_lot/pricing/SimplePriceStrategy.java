package com.example.lld.parking_lot.pricing;

import com.example.lld.parking_lot.Ticket;
import com.example.lld.parking_lot.constants.VehicleType;

public class SimplePriceStrategy implements PricingContext {

    private static final double BASE_BIKE_PRICE = 100;
    private static final double BASE_CAR_PRICE = 200;
    private static final double BASE_TRUCK_PRICE = 300;

    @Override
    public double getPrice(Ticket ticket) {

        VehicleType vehicleType = ticket.getVehicle().getVehicleType();

        if(VehicleType.BIKE.equals(vehicleType)){
            return BASE_BIKE_PRICE;
        }

        else if(VehicleType.CAR.equals(vehicleType)){
            return BASE_CAR_PRICE;
        }

        else if(VehicleType.TRUCK.equals(vehicleType)){
            return BASE_TRUCK_PRICE;
        }

        throw new RuntimeException("No Pricing strategy set for vehicle type: " + vehicleType);
    }
}
