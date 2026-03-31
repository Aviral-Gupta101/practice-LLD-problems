# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build Commands

```bash
mvn clean compile       # Compile
mvn test                # Run tests
mvn package             # Build JAR
```

Java 21, Maven build system. Main entry point: `src/main/java/com/example/lld/Main.java`.

## Architecture

This is a **Parking Lot LLD (Low-Level Design)** practice project demonstrating OOP design patterns in Java.

### Component Hierarchy

```
ParkingLotManager (Facade)
├── ParkingLot (Composite) → Level[] → AbstractParkingSpot[]
└── PricingContext (Strategy interface)
```

**ParkingLotManager** is the single entry point for clients — `parkCar(vehicle)` returns a `Ticket`, `exitVehicleAndGetPrice(ticket)` returns the fee.

**ParkingLot** owns multiple `Level` objects and a `carLevelMap` tracking which vehicle is on which level. It iterates levels to find a free spot.

**Level** owns multiple `AbstractParkingSpot` objects and a `vehicleParkingSpotMap`. Parking is `synchronized` on `Level.class` for thread safety.

**AbstractParkingSpot** uses a `volatile boolean isAvailable` field. Each subclass implements `isVehicleParkable(vehicle)` to enforce compatibility rules:
- `SmallParkingSpot` → Bikes only
- `CompactParkingSpot` → Bikes and Cars
- `LargeParkingSpot` → All vehicle types

### Design Patterns in Use

| Pattern | Where |
|---|---|
| Strategy | `PricingContext` — swap `SimplePriceStrategy` vs `TimeBasedPricingStrategy` |
| Template Method | `AbstractParkingSpot.parkCar()` — calls abstract `isVehicleParkable()` |
| Composite | `ParkingLot` → `Level` → `AbstractParkingSpot` |
| Facade | `ParkingLotManager` wraps `ParkingLot` + `PricingContext` |
| DTO | `Ticket` holds vehicle + entry timestamp for fee calculation |

### Pricing

`SimplePriceStrategy`: flat rates (Bike=100, Car=200, Truck=300).  
`TimeBasedPricingStrategy`: same base rates with 1.5x surcharge from 5 PM to 6 AM.

Both implement `PricingContext` — inject the desired strategy into `ParkingLotManager`.

### Thread Safety

Double-checked locking on `Level.class` in `Level.parkCar()` and on the specific spot class in `AbstractParkingSpot.parkCar()`. The `isAvailable` flag is `volatile`.
