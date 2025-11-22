package blind75.heaps.lc_295_find_median_from_data_stream;

import java.util.PriorityQueue;

public class MedianFinder {
    /**
     * The median is the middle value in an ordered integer list. If the size of the
     * list is even, there is no middle value, and the median is the mean of the two
     * middle values.
     * 
     * For example, for arr = [2,3,4], the median is 3.
     * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
     * 
     * Implement the MedianFinder class:
     * 
     * MedianFinder() initializes the MedianFinder object.
     * void addNum(int num) adds the integer num from the data stream to the data
     * structure.
     * double findMedian() returns the median of all elements so far. Answers within
     * 10-5 of the actual answer will be accepted.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input
     * ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
     * [[], [1], [2], [], [3], []]
     * Output
     * [null, null, null, 1.5, null, 2.0]
     */
    private PriorityQueue<Integer> leftQ;
    private PriorityQueue<Integer> rightQ;
    public MedianFinder() {
        this.leftQ = new PriorityQueue<>((a, b) -> b - a);
        this.rightQ = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (leftQ.isEmpty() || num < leftQ.peek()) {
            leftQ.offer(num);
        } else {
            rightQ.offer(num);
        }

        if (leftQ.size() > rightQ.size() + 1) {
            rightQ.offer(leftQ.poll());
        } else if (rightQ.size() > leftQ.size() + 1) {
            leftQ.offer(rightQ.poll());
        }
    }

    public double findMedian() {
        if (leftQ.size() > rightQ.size()) {
            return leftQ.peek();
        } else if (rightQ.size() > leftQ.size()) {
            return rightQ.peek();
        } else {
            return (double) (leftQ.peek() + rightQ.peek()) / 2;
        }
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());
    }
}
