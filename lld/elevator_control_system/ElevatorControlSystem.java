package lld.elevator_control_system;

import java.util.*;

public class ElevatorControlSystem {
    /**
     * DESIGN AN ELEVATOR CONTROL SYSTEM
     * - each building has multiple floors
     * - each building has multiple elevators
     * - each elevator:
     *  - has a current floor
     *   - can move up or down
     *   - can be idle
     * 
     *  requests:
     *  - can request an elevator from floor
     *  - can request a destination floor once inside an elevator
     * 
     *  rules:
     *   - elevators move one floor at a time
     *   - they move in one direction at a time
     *   - move in the current direction until no more requests exist in that direction
     * 
     *  the system should support:
     *  - requestElevator(sourceFloor, direction)
     *  - requestFloor(elevatorId, destinationFloor)
     *  - step() → moves the system forward by one time unit
     * 
     * CLASSES:
     * 
     * Building:
     * - floors: List<Floor>
     * - elevators: List<Elevator>
     * 
     * Floor:
     * 
     * Elevator
     * - currentFLoor: int
     * - state: ElevatorState
     * 
     * ElevatorState: enum
     * - UP, DOWN, IDLE
     * - id: long
     * 
     */


    enum ElevatorState {
        IDLE, UP, DOWN
    }

    enum Direction {
        UP, DOWN
    }

    class Elevator {
        long id;
        ElevatorState state = ElevatorState.IDLE;
        int currentFloor;
        PriorityQueue<Integer> up = new PriorityQueue<>();
        PriorityQueue<Integer> down = new PriorityQueue<>((a, b) -> b - a);

        public Elevator(long id) {
            this.id = id;
        }

        public long getId() { return id; }
        public ElevatorState getState() { return state; }
        public int getCurrentFLoor() { return currentFloor; }
        public boolean isIdle() { return this.getState() == ElevatorState.IDLE; }

        void addStop(int floor) {
            if (floor == currentFloor) return;

            if (floor < currentFloor) {
                down.offer(floor);
            } else {
                up.offer(floor);
            }
        }

        void moveOneFloor() {
            if (state == ElevatorState.IDLE) {
                if (!up.isEmpty()) {
                    state = ElevatorState.UP;
                } else if (!down.isEmpty()) {
                    state = ElevatorState.DOWN;
                } else {
                    return;
                }
            }

            if (state == ElevatorState.UP) {
                currentFloor++;
            } else if (state == ElevatorState.DOWN) {
                currentFloor--;
            }

            if (state == ElevatorState.UP && currentFloor == up.peek()) {
                up.poll();
            } else if (state == ElevatorState.DOWN && currentFloor == down.peek()) {
                down.poll();
            } else if (down.isEmpty() && up.isEmpty()) {
                state = ElevatorState.IDLE;
            }
        }
    }

    class Floor {
        int floorNumber;

        public Floor(int floorNumber) {
            this.floorNumber = floorNumber;
        }

        public int getFloorNumber() { return floorNumber; }

        void requestUp(Building building) {
           building.requestElevator(floorNumber, Direction.UP); 
        }

        void requestDown(Building building) {
            building.requestElevator(floorNumber, Direction.DOWN);
        }
    }
    
    
    class Building {
        List<Elevator> elevators = new ArrayList<>();

        void requestElevator(int floor, Direction direction) {
            Elevator requested = chooseElevator(floor);
            if (requested != null) {
                requested.addStop(floor);

                if (requested.isIdle()) {
                    requested.state = (direction == Direction.UP) ? ElevatorState.UP : ElevatorState.DOWN;
                }
            }
        }

        Elevator chooseElevator(int floor) {
            Elevator best = null;
            int minDistance = Integer.MAX_VALUE;

            for (Elevator e : elevators) {
                if (e.isIdle()) {
                    int distance = Math.abs(e.getCurrentFLoor() - floor);
                    if (distance < minDistance) {
                        best = e;
                        minDistance = distance;
                    }
                }
            }
            return (best == null && !elevators.isEmpty()) ? elevators.get(0) : best;
        }

        void step() {
            for (Elevator e : elevators) {
                e.moveOneFloor();
            }
        }
    }
}
