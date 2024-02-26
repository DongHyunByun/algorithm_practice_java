///**
// * Definition for a binary tree node.
// * public class TreeNode {
// *     int val;
// *     TreeNode left;
// *     TreeNode right;
// *     TreeNode() {}
// *     TreeNode(int val) { this.val = val; }
// *     TreeNode(int val, TreeNode left, TreeNode right) {
// *         this.val = val;
// *         this.left = left;
// *         this.right = right;
// *     }
// * }
// */
//class Solution {
//    public boolean dfs(TreeNode node, int now, int targetSum) {
//        // if leaf node
//        if (node.left==null & node.right==null) {
//            if (now+node.val==targetSum) {
//                return true;
//            }
//            else {
//                return false;
//            }
//        }
//
//        // if not leaf node
//        boolean a=false;
//        if (node.left!=null) {
//            a =  dfs(node.left, now+node.val, targetSum);
//        }
//
//        boolean b=false;
//        if (node.right!=null) {
//            b =  dfs(node.right, now+node.val, targetSum);
//        }
//
//        return (a||b);
//    }
//
//    public boolean hasPathSum(TreeNode root, int targetSum) {
//        if (root==null) {
//            return false;
//        } else {
//            return dfs(root, 0, targetSum);
//        }
//    }
//}