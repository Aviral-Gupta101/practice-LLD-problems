package com.example.lld.parking_lot.cars;

import com.example.lld.parking_lot.constants.VehicleType;

public class Bike extends AbstractVehicle {

    public Bike(String carNumber) {
        super(VehicleType.BIKE);
        super.setCarNumber(carNumber);
    }
}
