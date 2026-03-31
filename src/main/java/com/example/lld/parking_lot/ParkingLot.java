package com.example.lld.parking_lot;

import com.example.lld.parking_lot.cars.AbstractVehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {

    private final List<Level> levels;
    private final Map<String, Level> carLevelMap = new HashMap<>();

    public ParkingLot() {
        this.levels = new ArrayList<>();
    }

    public ParkingLot(List<Level> levels) {
        this.levels = levels;
    }

    public void addLevel(Level level){
        levels.add(level);
    }

    boolean parkCar(AbstractVehicle vehicle){

        for(var level: levels){
            if(level.getAvailableParkingSpot(vehicle) != null){

                boolean result = level.parkCar(vehicle);

                if(result) {
                    carLevelMap.put(vehicle.getCarNumber(), level);
                    return true;
                }
            }
        }

        System.out.println("Unable to park car");
        return false;
    }

    boolean vacantCar(AbstractVehicle vehicle){

        Level level = carLevelMap.get(vehicle.getCarNumber());

        if(level != null){

            level.vacantVehicle(vehicle);
            carLevelMap.remove(vehicle.getCarNumber());
            return true;
        }

        return false;
    }
}
