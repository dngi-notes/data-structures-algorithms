package blind75.graphs.lc_207_course_schedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
     * 
     * 
     * Example 1:
     * 
     * Input: numCourses = 2, prerequisites = [[1,0]]
     * Output: true
     * Explanation: There are a total of 2 courses to take.
     * To take course 1 you should have finished course 0. So it is possible.
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer> visiting = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int[] pre : prerequisites) {
            int u = pre[0];
            int v = pre[1];
            graph.get(u).add(v);
        }

        for (int c = 0; c < numCourses; c++) {
            if (!dfs(c, graph, visiting)) {
                return false;
            }

        }
        return true;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> graph, Set<Integer> visiting) {
        if (visiting.contains(course)) {
            return false;
        }

        if (graph.get(course).isEmpty()) {
            return true;
        }

        visiting.add(course);
        for (int pre: graph.get(course)) {
            if (!dfs(pre, graph, visiting)) {
                return false;
            }
        }

        visiting.remove(course);
        graph.put(course, new ArrayList<>());
        return true;
    }
}
