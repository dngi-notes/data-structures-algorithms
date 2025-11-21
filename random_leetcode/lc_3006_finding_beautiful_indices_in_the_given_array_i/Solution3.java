package random_leetcode.lc_3006_finding_beautiful_indices_in_the_given_array_i;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    /**
     * given:
     * String s, a, b
     * int k
     * 
     * return:
     * all indices i, where:
     * - substring a occurs at i
     * - there exists some index j, where b occurs
     * - and the distance |i - j| <= k
     * i.e. each i is close enough to some occurrence of b
     * 
     * e.g.
     * s = xyzxyzxyz
     * a = "xyz", b = "yz"
     * k = 0
     * output = a -> [0, 3, 6], b -> [1, 4, 7]
     */
    public List<Integer> findAllIndicesWithinDistance(String s, String a, String b, int k) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return res;
        }

        int n = s.length();
        List<Integer> allStartA = new ArrayList<>();
        List<Integer> allStartB = new ArrayList<>();

        for (int i = 0; i < n - a.length() + 1; i++) {
            String stringSizeA = s.substring(i, i + a.length());
            if (stringSizeA.equals(a)) {
                allStartA.add(i);
            }
        }

        for (int i = 0; i < n - b.length() + 1; i++) {
            String stringSizeB = s.substring(i, i + b.length());
            if (stringSizeB.equals(b)) {
                allStartB.add(i);
            }
        }

        for (int i = 0; i < allStartA.size(); i++) {
            int aIndex = allStartA.get(i);
            int idx = binarySearch(allStartB, aIndex);

            int bestDistance = Integer.MAX_VALUE;
            if (idx - 1 >= 0) {
                bestDistance = Math.min(bestDistance, Math.abs(aIndex - allStartB.get(idx - 1)));
            }

            if (idx < allStartB.size()) {
                bestDistance = Math.min(bestDistance, Math.abs(aIndex - allStartB.get(idx)));
            }

            if (bestDistance <= k) {
                res.add(aIndex);
            }
        }

        return res;
    }

    private int binarySearch(List<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) == target) {
                return mid;
            } else if (list.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        Solution3 ss = new Solution3();
        System.out.println(ss.findAllIndicesWithinDistance("xyzxyzxyz", "xyz", "yz", 0));
    }
}
