package com.system.design.edu.parkinglot;

public class ElectricSpot extends ParkingSpot {
    public ElectricSpot() {
        super(ParkingSpotType.ELECTRIC);
    }

    @Override
    public boolean isFree() {
        return false;
    }
}
