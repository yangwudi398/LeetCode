/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, -1, -1);
    }
    
    public boolean helper(TreeNode root, int lower, int upper) {        
        if (root == null)
            return true;
        if (lower != -1 && root.val <= lower)
            return false;
        if (upper != -1 && root.val >= upper)
            return false;
        
        return helper(root.left, lower, root.val) && helper(root.right, root.val, upper);
    }
}