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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        traverse(root, ans);
        return ans;
    }
    
    private void traverse(TreeNode root, List<Integer> list) {
        if (root != null) {
            traverse(root.left, list);
            list.add(root.val);
            traverse(root.right, list);
        }
    } 
}