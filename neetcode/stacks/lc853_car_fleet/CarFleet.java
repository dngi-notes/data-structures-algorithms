package neetcode.stacks.lc853_car_fleet;

import java.util.Arrays;
import java.util.Stack;

public class CarFleet {
    /*
     * There are n cars at given miles away from the starting mile 0, traveling to
     * reach the mile target.
     * 
     * You are given two integer array position and speed, both of length n, where
     * position[i] is the starting mile of the ith car and speed[i] is the speed of
     * the ith car in miles per hour.
     * 
     * A car cannot pass another car, but it can catch up and then travel next to it
     * at the speed of the slower car.
     * 
     * A car fleet is a car or cars driving next to each other. The speed of the car
     * fleet is the minimum speed of any car in the fleet.
     * 
     * If a car catches up to a car fleet at the mile target, it will still be
     * considered as part of the car fleet.
     * 
     * Return the number of car fleets that will arrive at the destination.
     */
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        int[][] cars = new int[n][2];
        for(int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> b[0] - a[0]);
        Stack<Double> fleetTimes = new Stack<>();

        for(int i = 0; i < cars.length; i++) {
            int[] car = cars[i];
            double timeToReachTarget = (double) (target - car[0]) / car[1];

            if(fleetTimes.isEmpty() || timeToReachTarget > fleetTimes.peek()) {
                fleetTimes.push(timeToReachTarget);
            }
        }

        return fleetTimes.size();
    }

    public static void main(String[] args) {
        CarFleet cf = new CarFleet();
        String output = "Output: ";

        int[] pos1 = {10, 8, 0, 5, 3};
        int[] speed1 = {2, 4, 1, 1, 3};
        System.out.println(output + cf.carFleet(12, pos1, speed1));
    }
}
