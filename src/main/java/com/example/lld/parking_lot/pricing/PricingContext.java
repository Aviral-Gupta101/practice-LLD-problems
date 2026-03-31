package com.example.lld.parking_lot.pricing;

import com.example.lld.parking_lot.Ticket;
import com.example.lld.parking_lot.constants.VehicleType;

public interface PricingContext {

    double getPrice(Ticket ticket);
}
