package google.medium.lc_207_course_schedule;

import java.util.*;

public class Solution {
    /**
     * There are a total of numCourses courses you have to take, labeled from 0 to
     * numCourses - 1. You are given an array prerequisites where prerequisites[i] =
     * [ai, bi] indicates that you must take course bi first if you want to take
     * course ai.
     * 
     * For example, the pair [0, 1], indicates that to take course 0 you have to
     * first take course 1.
     * 
     * Return true if you can finish all courses. Otherwise, return false.
     * 
     * Example 1:
     * 
     * Input: numCourses = 2, prerequisites = [[1,0]]
     * Output: true
     * Explanation: There are a total of 2 courses to take.
     * To take course 1 you should have finished course 0. So it is possible.
     * 
     * Example 2:
     * 
     * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
     * Output: false
     * Explanation: There are a total of 2 courses to take.
     * To take course 1 you should have finished course 0, and to take course 0 you
     * should also have finished course 1. So it is impossible.
     * 
     * Constraints:
     * 
     * 1 <= numCourses <= 2000
     * 0 <= prerequisites.length <= 5000
     * prerequisites[i].length == 2
     * 0 <= ai, bi < numCourses
     * All the pairs prerequisites[i] are unique.
     * 
     * notes:
     * - looking for cycles (if there's a cycle, cant complete all courses (false), else true)
     * - 
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) return true;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int prereq = pre[1];
            int req = pre[0];
            adj.get(prereq).add(req);
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();
        for (int c = 0; c < numCourses; c++) {
            if (hasCycle(c, adj, visiting, visited)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(int node, List<List<Integer>> adj, Set<Integer> visiting, Set<Integer> visited) {
        visiting.add(node);

        for (int nei : adj.get(node)) {
            if (visiting.contains(nei)) {
                return true;
            } else if (!visited.contains(nei)) {
                if (hasCycle(nei, adj, visiting, visited)) {
                    return true;
                }
            }
        }

        visiting.remove(node);
        visited.add(node);
        return false;
    }
}
