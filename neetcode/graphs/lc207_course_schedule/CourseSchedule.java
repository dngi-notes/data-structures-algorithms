package neetcode.graphs.lc207_course_schedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseSchedule {
    /*
     * There are a total of numCourses courses you have to take, labeled from 0 to
     * numCourses - 1. You are given an array prerequisites where prerequisites[i] =
     * [ai, bi] indicates that you must take course bi first if you want to take
     * course ai.
     * 
     * For example, the pair [0, 1], indicates that to take course 0 you have to
     * first take course 1.
     * Return true if you can finish all courses. Otherwise, return false.
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        Set<Integer> visiting = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            preMap.get(pair[0]).add(pair[1]);
        }

        for (int c = 0; c < numCourses; c++) {
            if (!dfs(c, preMap, visiting)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> preMap, Set<Integer> visiting) {
        if (visiting.contains(course)) {
            return false;
        }

        if(preMap.get(course).isEmpty()) {
            return true;
        }
        
        visiting.add(course);
        for(int prereq : preMap.get(course)) {
            if(!dfs(prereq, preMap, visiting)) {
                return false;
            }
        }

        visiting.remove(course);
        preMap.put(course, new ArrayList<>());
        return true;
    }

    /*
     * Time: O(n + p), where n is number of courses, p is number of prerequisites
     * Space: O(n + p)
     */
}
