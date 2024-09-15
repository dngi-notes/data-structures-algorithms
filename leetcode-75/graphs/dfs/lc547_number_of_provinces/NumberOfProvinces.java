package graphs.dfs.lc547_number_of_provinces;

import java.util.HashSet;
import java.util.Set;

public class NumberOfProvinces {
    /*
     * There are n cities. Some of them are connected, while some are not. If city a
     * is connected directly with city b, and city b is connected directly with city
     * c, then city a is connected indirectly with city c.
     * 
     * A province is a group of directly or indirectly connected cities and no other
     * cities outside of the group.
     * 
     * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the
     * ith city and the jth city are directly connected, and isConnected[i][j] = 0
     * otherwise.
     * 
     * Return the total number of provinces.
     */
    public int findCircleNum(int[][] isConnected) {
        if(isConnected == null || isConnected.length == 0 || isConnected[0].length == 0) {
            return 0;
        }
        int n = isConnected.length;
        Set<Integer> visited = new HashSet<>();
        int numberOfProvinces = 0;
        for(int i = 0; i < n; i++) {
            if(!visited.contains(i)) {
                dfs(i, visited, isConnected);
                numberOfProvinces++;
            }
        }

        return numberOfProvinces;
    }
    
    private void dfs(int start, Set<Integer> visited, int[][] isConnected) {
        visited.add(start);

        for(int j = 0; j < isConnected.length; j++) {
            if(isConnected[start][j] == 1 && !visited.contains(j)) {
                dfs(j, visited, isConnected);
            }
        }
    }

    /*
     * Time Complexity: O(n ^ 2)
     * Space Complexity: O(n ^ 2)
     */

    public static void main(String[] args) {
        NumberOfProvinces nop = new NumberOfProvinces();
        String output = "Output: ";

        int[][] grid1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(output + nop.findCircleNum(grid1));

        int[][] grid2 = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        System.out.println(output + nop.findCircleNum(grid2));

        int[][] grid3 = null;
        System.out.println(output + nop.findCircleNum(grid3));

        int[][] grid4 = {{}};
        System.out.println(output + nop.findCircleNum(grid4));
    }
}
