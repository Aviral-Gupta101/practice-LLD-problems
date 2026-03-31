package com.example.lld.parking_lot;

import com.example.lld.parking_lot.cars.AbstractVehicle;

import java.time.LocalDateTime;

public class Ticket {

    private final AbstractVehicle vehicle;
    private final LocalDateTime ticketIssuedAt;

    public Ticket(AbstractVehicle vehicle) {
        this.vehicle = vehicle;
        this.ticketIssuedAt = LocalDateTime.now();
    }

    public AbstractVehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getTicketIssuedAt() {
        return ticketIssuedAt;
    }
}
