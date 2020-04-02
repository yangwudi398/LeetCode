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
    TreeNode common = null;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findCommon(root, p, q);
        return common;
    }
    
    private int findCommon(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return 0;
        
        int curr = (root == p || root == q) ? 1 : 0;
        int left = findCommon(root.left, p, q);
        int right = findCommon(root.right, p, q);
        
        if (curr + left + right >= 2) {
            this.common = root;
            return 0;
        }
            
        return curr + left + right;
    }
}