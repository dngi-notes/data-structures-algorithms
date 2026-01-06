package google.easy.lc_225_implement_stack_with_queues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement a last-in-first-out (LIFO) stack using only two queues. The
 * implemented stack should support all the functions of a normal stack (push,
 * top, pop, and empty).
 * 
 * Implement the MyStack class:
 * 
 * void push(int x) Pushes element x to the top of the stack.
 * int pop() Removes the element on the top of the stack and returns it.
 * int top() Returns the element on the top of the stack.
 * boolean empty() Returns true if the stack is empty, false otherwise.
 * 
 * Notes:
 * 
 * You must use only standard operations of a queue, which means that only push
 * to back, peek/pop from front, size and is empty operations are valid.
 * Depending on your language, the queue may not be supported natively. You may
 * simulate a queue using a list or deque (double-ended queue) as long as you
 * use only a queue's standard operations.
 * 
 */

public class Solution {
    private Queue<Integer> pushQueue;
    private Queue<Integer> popQueue;

    public Solution() {
        pushQueue = new LinkedList<>();
        popQueue = new LinkedList<>();
    }

    public void push(int x) {
        pushQueue.offer(x);
    }

    public int pop() {
        while (pushQueue.size() > 1) {
            popQueue.offer(pushQueue.poll());
        }

        int val = pushQueue.poll();
        swapQueues();
        return val;
    }

    public int top() {
        while (pushQueue.size() > 1) {
            popQueue.offer(pushQueue.poll());
        }

        int val = pushQueue.poll();
        popQueue.offer(val);
        swapQueues();
        return val;
    }

    public boolean empty() {
        return pushQueue.isEmpty() && popQueue.isEmpty();
    }

    private void swapQueues() {
        Queue<Integer> temp;
        temp = pushQueue;
        pushQueue = popQueue;
        popQueue = temp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println(s.top());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.empty());
    }
}