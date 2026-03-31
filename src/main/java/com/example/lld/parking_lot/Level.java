package com.example.lld.parking_lot;

import com.example.lld.parking_lot.cars.AbstractVehicle;
import com.example.lld.parking_lot.parking_spot.AbstractParkingSpot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Level {

    private final int level;
    private final List<AbstractParkingSpot> parkingSpots;

    private final Map<String, AbstractParkingSpot> vehicleParkingSpotMap = new HashMap<>();

    public Level(int level, List<AbstractParkingSpot> parkingSpots) {
        this.level = level;
        this.parkingSpots = parkingSpots;
    }

    public Level(int level) {
        this.level = level;
        this.parkingSpots = new ArrayList<>();
    }

    public int getLevel() {
        return level;
    }

    public void addParkingSpot(AbstractParkingSpot parkingSpot){
        parkingSpots.add(parkingSpot);
    }

    public AbstractParkingSpot getAvailableParkingSpot(AbstractVehicle vehicle){

        return parkingSpots.stream().filter(spot -> spot.isVehicleParkable(vehicle))
                .findFirst().orElse(null);
    }

    public boolean parkCar(AbstractVehicle vehicle){

        AbstractParkingSpot availableParkingSpot = getAvailableParkingSpot(vehicle);

        if(availableParkingSpot != null){

            synchronized (Level.class){

                if(getAvailableParkingSpot(vehicle) != null){

                    boolean result = availableParkingSpot.parkCar(vehicle);

                    if(result) {
                        vehicleParkingSpotMap.put(vehicle.getCarNumber(), availableParkingSpot);
                        return true;
                    }
                }
            }
        }

        System.out.println("Level: " + level + " No parking spot available for vehicle: " + vehicle);
        return false;
    }

    public boolean vacantVehicle(AbstractVehicle vehicle){

        AbstractParkingSpot abstractParkingSpot = vehicleParkingSpotMap.get(vehicle.getCarNumber());

        if(abstractParkingSpot == null){

            System.out.println("Level: " + level + " No vehicle parked at this level for " + vehicle);
            return false;
        }

        abstractParkingSpot.vacantCar();
        vehicleParkingSpotMap.remove(vehicle.getCarNumber());
        return true;
    }
}
