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

}
