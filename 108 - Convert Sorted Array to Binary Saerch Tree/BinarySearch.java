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
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode dummy = new TreeNode(0);
        convertBinaryTree(nums, 0, nums.length - 1, dummy, true);
        return dummy.left;
    }
    
    private void convertBinaryTree(int[] nums, int low, int high, TreeNode root, boolean left) {
        if (low > high)
            return;
        
        int mid = (low + high) / 2;
        int val = nums[mid];
        
        if (left) {
            root.left = new TreeNode(val);
            root = root.left;
        } else {
            root.right = new TreeNode(val);
            root = root.right;
        }
        
        convertBinaryTree(nums, low, mid - 1, root, true);
        convertBinaryTree(nums, mid + 1, high, root, false);
    }
}