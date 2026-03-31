package com.example.lld.parking_lot.cars;

import com.example.lld.parking_lot.constants.VehicleType;

public class Car extends AbstractVehicle {

    public Car(String carNumber) {
        super(VehicleType.CAR);
        super.setCarNumber(carNumber);
    }
}
