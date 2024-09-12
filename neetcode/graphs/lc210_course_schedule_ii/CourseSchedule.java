package neetcode.graphs.lc210_course_schedule_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.List;

public class CourseSchedule {
    /*
     * There are a total of numCourses courses you have to take, labeled from 0 to
     * numCourses - 1. You are given an array prerequisites where prerequisites[i] =
     * [ai, bi] indicates that you must take course bi first if you want to take
     * course ai.
     * 
     * For example, the pair [0, 1], indicates that to take course 0 you have to
     * first take course 1.
     * Return the ordering of courses you should take to finish all courses. If
     * there are many valid answers, return any of them. If it is impossible to
     * finish all courses, return an empty array.
     * 
     * 1 <= numCourses <= 2000
     * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
     * prerequisites[i].length == 2
     * 0 <= ai, bi < numCourses
     * ai != bi
     * All the pairs [ai, bi] are distinct.
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> courseOrder = new ArrayList<>();

        if(prerequisites == null) {
            return new int[]{};
        }

        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            preMap.get(pair[0]).add(pair[1]);
        }

        for (int c = 0; c < numCourses; c++) {
            if (!getCourseOrder(c, preMap, visiting, visited, courseOrder)) {
                return new int[0];
            }
        }
        int[] result = new int[numCourses];
        for (int i = 0; i < courseOrder.size(); i++) {
            result[i] = courseOrder.get(i);
        }

        return result;
    }

    private boolean getCourseOrder(int course, Map<Integer, List<Integer>> preMap, Set<Integer> visiting,
            Set<Integer> visited, List<Integer> courseOrder) {
        if (visited.contains(course)) {
            return true;
        }

        if (visiting.contains(course)) {
            return false;
        }

        visiting.add(course);
        for (int pre : preMap.get(course)) {
            if (!getCourseOrder(pre, preMap, visiting, visited, courseOrder)) {
                return false;
            }
        }

        visited.add(course);
        visiting.remove(course);
        courseOrder.add(course);
        return true;
    }

    /*
     * Time Complexity: O(n + p) n is the number of courses, p is the number of prerequisites
     * Space Complexity: O(n + p)
     */

    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();
        String output = "Output: ";

        int[][] prerequisites1 = {{1, 0}};
        String result1 = Arrays.toString(cs.findOrder(2, prerequisites1));
        System.out.println(output + result1);

        int[][] prerequisites2 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        String result2 = Arrays.toString(cs.findOrder(4, prerequisites2));
        System.out.println(output + result2);

        int[][] prerequisites3 = {};
        String result3 = Arrays.toString(cs.findOrder(1, prerequisites3));
        System.out.println(output + result3);

        int[][] prerequisites4 = null;
        String result4 = Arrays.toString(cs.findOrder(1, prerequisites4));
        System.out.println(output + result4);

        int[][] prerequisites5 = {};
        String result5 = Arrays.toString(cs.findOrder(4, prerequisites5));
        System.out.println(output + result5);
    }
}
