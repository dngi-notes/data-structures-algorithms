package random_leetcode.lc637_average_of_levels_in_binary_tree;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import data_structures.TreeNode;

public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Double> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (q.isEmpty()) {
            int size = q.size();
            double average = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node != null) {
                    if (node.left != null) q.offer(node.left);
                    if (node.right != null) q.offer(node.right);                    
                }
            }

            result.add(average / size);
        }

        return result;
    }    
}
