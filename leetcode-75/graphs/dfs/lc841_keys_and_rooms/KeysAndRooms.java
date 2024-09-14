package graphs.dfs.lc841_keys_and_rooms;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class KeysAndRooms {
    /*
     * There are n rooms labeled from 0 to n - 1 and all the rooms are locked except
     * for room 0. Your goal is to visit all the rooms. However, you cannot enter a
     * locked room without having its key.
     * 
     * When you visit a room, you may find a set of distinct keys in it. Each key
     * has a number on it, denoting which room it unlocks, and you can take all of
     * them with you to unlock the other rooms.
     * 
     * Given an array rooms where rooms[i] is the set of keys that you can obtain if
     * you visited room i, return true if you can visit all the rooms, or false
     * otherwise.
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        visited[0] = true;

        while(!stack.isEmpty()) {
            int currentRoom = stack.pop();
            for(int key : rooms.get(currentRoom)) {
                if(!visited[key]) {
                    visited[key] = true;
                    stack.push(key);
                }
            }
        }

        for(boolean roomVisited : visited) {
            if(!roomVisited) {
                return false;
            }
        }
        return true;
    }

    /*
     * Time Complexity: O(V + E), where v is the rooms, and e is the keys
     * Space Complexity: O(n), where in is the number of rooms
     */

    public static void main(String[] args) {
        KeysAndRooms kar = new KeysAndRooms();
        
        // Test case 1: All rooms can be visited
        List<List<Integer>> rooms1 = new ArrayList<>();
        rooms1.add(List.of(1));
        rooms1.add(List.of(2));
        rooms1.add(List.of(3));
        rooms1.add(new ArrayList<>());
        System.out.println("Test case 1: " + kar.canVisitAllRooms(rooms1)); // Expected: true

        // Test case 2: Not all rooms can be visited
        List<List<Integer>> rooms2 = new ArrayList<>();
        rooms2.add(List.of(1, 3));
        rooms2.add(List.of(3, 0, 1));
        rooms2.add(List.of(2));
        rooms2.add(List.of(0));
        System.out.println("Test case 2: " + kar.canVisitAllRooms(rooms2)); // Expected: false

        // Test case 3: Single room
        List<List<Integer>> rooms3 = new ArrayList<>();
        rooms3.add(new ArrayList<>());
        System.out.println("Test case 3: " + kar.canVisitAllRooms(rooms3)); // Expected: true

        // Test case 4: Multiple rooms with no keys
        List<List<Integer>> rooms4 = new ArrayList<>();
        rooms4.add(new ArrayList<>());
        rooms4.add(new ArrayList<>());
        rooms4.add(new ArrayList<>());
        System.out.println("Test case 4: " + kar.canVisitAllRooms(rooms4)); // Expected: false
    }
}
