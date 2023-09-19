package com.studies.springdesingpatterns.FactoryPattern;

public class CarFactory implements VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }

    public class Car extends Vehicle {

    }
}
