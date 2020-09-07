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
class Solution {
    public int sumNumbers(TreeNode root) {
        return getSum(root, 0);
    }
    
    private int getSum(TreeNode root, int currSum) {
        if (root == null)
            return currSum;
        
        int newSum = currSum * 10 + root.val;
        
        if (root.left == null && root.right == null)
            return newSum;
        if (root.left == null)
            return getSum(root.right, newSum);
        if (root.right == null)
            return getSum(root.left, newSum);
        return getSum(root.left, newSum) + getSum(root.right, newSum);
    }
}