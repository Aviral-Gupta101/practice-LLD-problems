package com.example.lld.parking_lot.parking_spot;

import com.example.lld.parking_lot.cars.AbstractVehicle;
import com.example.lld.parking_lot.constants.ParkingSpotType;
import com.example.lld.parking_lot.constants.VehicleType;

public class CompactParkingSpot extends AbstractParkingSpot {

    public CompactParkingSpot() {
        super(ParkingSpotType.COMPACT);
    }

    @Override
    public boolean isVehicleParkable(AbstractVehicle vehicle) {

        if(!isAvailable()){

            System.out.println("ParkingSpot occupied by: " + getVehicle());
            return false;
        }

        return VehicleType.BIKE.equals(vehicle.getVehicleType()) || VehicleType.CAR.equals(vehicle.getVehicleType());

    }

    @Override
    public boolean parkCar(AbstractVehicle vehicle) {

        if(isVehicleParkable(vehicle)){

            synchronized (CompactParkingSpot.class){

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
