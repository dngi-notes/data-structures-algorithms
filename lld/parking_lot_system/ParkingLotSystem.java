package lld.parking_lot_system;

import java.util.*;

/**
 * | DESIGN PARKING LOT SYSTEM |
 * -----------------------------
 * you're asked to design a parking lot that supports
 *  multiple types of vehicles and parking spots
 * 
 * requirements:
 * 1. the parking lot has multiple floors
 * 
 * 2. each floor has parking spots of different sizes
 *  - MOTORCYCLE
 *  - COMPACT
 *  - LARGE
 * 
 * 3. vehicles
 *  - MOTORCYCLE
 *  - CAR
 *  - BUS
 * 
 * 4. rules:
 *  - a motorcycle can park anywhere
 *  - a car can park in compact and large spaces
 *  - a bus requires 5 contiguous large spots on the same floor
 * 
 * 5. the system should support the following functions:
 *  - parkVehicle(vehicle)
 *  - unparkVehicle(vehicle)
 *  - a function to check availability
 */

enum VehicleSize {
    MOTORCYCLE,
    COMPACT,
    LARGE
}

abstract class Vehicle {
    protected int spotsNeeded;
    protected VehicleSize size;

    public int getSpotsNeeded() { return spotsNeeded; }
    public VehicleSize getSize() { return size; }
}

class Car extends Vehicle {
    public Car() {
        spotsNeeded = 1;
        size = VehicleSize.COMPACT;
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle() {
        spotsNeeded = 1;
        size = VehicleSize.MOTORCYCLE;
    }   
}

class Bus extends Vehicle {
    public Bus() {
        spotsNeeded = 5;
        size = VehicleSize.LARGE;
    }
}

class ParkingSpot {
    private VehicleSize size;
    private Vehicle currentVehicle;

    boolean canFit(Vehicle vehicle) {
        if (currentVehicle != null) return false;
        return switch (vehicle.getSize()) {
            case MOTORCYCLE -> true;
            case COMPACT -> size != VehicleSize.MOTORCYCLE;
            case LARGE -> size == VehicleSize.LARGE;
        };
    }

    void park(Vehicle v) {
        currentVehicle = v;
    }

    void removeVehicle() {
        currentVehicle = null;
    }
}


public class ParkingLotSystem {
    private List<ParkingSpot> spots;

    boolean parkVehicle(Vehicle vehicle) {
        if (vehicle instanceof Bus) {
            return parkBus ((Bus) vehicle);
        }

        for (ParkingSpot spot : spots) {
            if (spot.canFit(vehicle)) {
                spot.park(vehicle);
                return true;
            }
        }

        return false;
    }

    boolean unparkVehicle(int idx) {
        if (spots.get(idx) != null) {
            spots.get(idx).removeVehicle();
            return true;
        }

        return false;
    }

    private boolean parkBus(Bus bus) {
        int count = 0;
        for (int i = 0; i < spots.size(); i++) {
            if (spots.get(i).canFit(bus)) {
                count++;

                if (count == 5) {
                    for (int j = i; j > i - 5; j--) {
                        spots.get(j).park(bus);
                    }

                    return true;
                }
            } else {
                count = 0;
            }
        }

        return false;
    }
}
