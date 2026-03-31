package com.example.lld.parking_lot.cars;

import com.example.lld.parking_lot.constants.VehicleType;

public abstract class AbstractVehicle {

    private final VehicleType vehicleType;

    private String carNumber;

    public AbstractVehicle(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getCarNumber() {
        return carNumber;
    }

    protected void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }
}
