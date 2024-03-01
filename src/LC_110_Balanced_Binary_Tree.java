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
//    public int returnDepth(TreeNode root) {
//        if (root==null) {
//            return 0;
//        } else {
//            return Math.max(returnDepth(root.left)+1,returnDepth(root.right)+1);
//        }
//    }
//    public boolean isBalanced(TreeNode root) {
//        if (root==null) {
//            return true;
//        } else {
//            if (Math.abs(returnDepth(root.left)-returnDepth(root.right))<=1) {
//                return (isBalanced(root.left) && isBalanced(root.right));
//            } else {
//                return false;
//            }
//        }
//    }
//}