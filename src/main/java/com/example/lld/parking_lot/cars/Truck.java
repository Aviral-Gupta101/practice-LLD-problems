package com.example.lld.parking_lot.cars;

import com.example.lld.parking_lot.constants.VehicleType;

public class Truck extends AbstractVehicle {

    public Truck(String carNumber) {
        super(VehicleType.TRUCK);
        super.setCarNumber(carNumber);
    }
}
