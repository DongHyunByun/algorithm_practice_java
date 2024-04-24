package graph;

import java.util.ArrayList;
import java.util.List;

public class LC_94_binary_tree_inorder_traversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {
        public void dfs(TreeNode node, List<Integer> list) {
            if (node != null) {
                dfs(node.left, list);
                list.add(node.val);
                dfs(node.right, list);
            }
        }

        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            dfs(root, list);

            return list;
        }
    }

}
