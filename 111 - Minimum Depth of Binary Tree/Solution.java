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
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        return getMinDepth(root, 0);
    }
    
    private int getMinDepth(TreeNode root, int currDepth) {	
        if (root.left == null && root.right == null)
            return currDepth + 1;
        if (root.left == null)
            return getMinDepth(root.right, currDepth + 1);
        if (root.right == null)
            return getMinDepth(root.left, currDepth + 1);
        return Math.min(getMinDepth(root.left, currDepth + 1), getMinDepth(root.right, currDepth + 1));
    }
}