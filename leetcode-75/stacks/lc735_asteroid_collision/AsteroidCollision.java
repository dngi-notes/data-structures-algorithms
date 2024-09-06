package stacks.lc735_asteroid_collision;

import java.util.Stack;

public class AsteroidCollision {
    /*
     * We are given an array asteroids of integers representing asteroids in a row.
     *
     * For each asteroid, the absolute value represents its size, and the sign represents its direction 
     * (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
     *
     * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one 
     * will explode. If both are the same size, both will explode. Two asteroids moving in the same 
     * direction will never meet.
     */
    public int[] asteroidCollision(int[] asteroids) {
        /*
         * initialise a stack
         * for every asteroid in asteroids
         *  - initialise a boolean for exploded
         *  - while the stack isnt empty and the value of the asteroid is positive (> 0), and the top of the stack is positive,
         *  ----> if the absolute value of the top of the stack is less that the absolute value of the current asteroid, pop from the stack  (also skip it)
         *  else if they are equal to each other, pop from stack
         * 
         * set exploded to true
         * break from the loop
         * 
         * if there was no explosion, push the asteroid to the stack
         * 
         * create result array from values in the stack
         * return result;
         * 
         */

        Stack<Integer> stack = new Stack<>();

        for(int asteroid : asteroids) {
            boolean exploded  = false;
            while(!stack.isEmpty() && asteroid > 0 && stack.peek() > 0) {
                if(Math.abs(stack.peek()) < Math.abs(asteroid)) {
                    stack.pop();
                    continue;
                }

                else if(Math.abs(stack.peek()) == Math.abs(asteroid)) {
                    stack.pop();
                }

                exploded = true;
                break;
            }

            if(!exploded) {
                stack.push(asteroid);
            }
        }

        int[] result = new int[stack.size()];
        for(int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.get(i);
        }

        return result;
    }
}