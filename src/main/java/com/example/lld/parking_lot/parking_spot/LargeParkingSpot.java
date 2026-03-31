package com.example.lld.parking_lot.parking_spot;

import com.example.lld.parking_lot.cars.AbstractVehicle;
import com.example.lld.parking_lot.constants.ParkingSpotType;
import com.example.lld.parking_lot.constants.VehicleType;

public class LargeParkingSpot extends AbstractParkingSpot {

    public LargeParkingSpot() {
        super(ParkingSpotType.LARGE);
    }

    @Override
    public boolean isVehicleParkable(AbstractVehicle vehicle) {

        if(!isAvailable()){

            System.out.println("ParkingSpot occupied by: " + getVehicle());
            return false;
        }

        return true;
    }

    @Override
    public boolean parkCar(AbstractVehicle vehicle) {

        if(isVehicleParkable(vehicle)){

            synchronized (LargeParkingSpot.class){

                if(isVehicleParkable(vehicle)){

                    setAvailable(false);
                    setVehicle(vehicle);
                    return true;
                }
            }
        }

        return false;
    }
}
