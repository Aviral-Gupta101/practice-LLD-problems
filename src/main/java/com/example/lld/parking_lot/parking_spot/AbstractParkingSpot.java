package com.example.lld.parking_lot.parking_spot;

import com.example.lld.parking_lot.cars.AbstractVehicle;
import com.example.lld.parking_lot.constants.ParkingSpotType;

public abstract class AbstractParkingSpot {

    private final ParkingSpotType parkingSpotType;

    private volatile boolean isAvailable;
    private AbstractVehicle vehicle;

    public AbstractParkingSpot(ParkingSpotType parkingSpotType) {
        this.parkingSpotType = parkingSpotType;
        isAvailable = true;
    }

    public ParkingSpotType getParkingSpotType() {
        return parkingSpotType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    protected void setAvailable(boolean available) {
        isAvailable = available;
    }

    public AbstractVehicle getVehicle() {
        return vehicle;
    }

    protected void setVehicle(AbstractVehicle vehicle) {
        this.vehicle = vehicle;
    }

    // GETTER SETTER END

    public void vacantCar(){
        setAvailable(true);
        setVehicle(null);
    }

    public abstract boolean isVehicleParkable(AbstractVehicle vehicle);

    public abstract boolean parkCar(AbstractVehicle vehicle);


}
