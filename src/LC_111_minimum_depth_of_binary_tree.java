/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//class Solution {
//    public int dfs(TreeNode node, int depth) {
//
//        // 둘다없으면
//        if (node.left==null & node.right==null) {
//            return depth;
//        }
//
//        // 둘중하나만 있으면
//        if (node.left==null | node.right==null) {
//            int a=9876543;
//            int b=9876543;
//            if (node.left==null) {
//                a = dfs(node.right, depth+1);
//            } else if (node.right==null) {
//                b = dfs(node.left, depth+1);
//            }
//            return Math.min(a,b);
//        }
//
//        // 둘다있으면
//        return Math.min(dfs(node.right, depth+1),dfs(node.left, depth+1));
//
//
//    }
//
//    public int minDepth(TreeNode root) {
//        if (root==null) {
//            return 0;
//        } else {
//            return dfs(root,1);
//        }
//    }
//}