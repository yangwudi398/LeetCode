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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        res.add(root.val);
        
        // Get left boundary
        if (root.left != null) {
            TreeNode currLeft = root.left;
            while (currLeft.left != null || currLeft.right != null) {
                res.add(currLeft.val);
                if (currLeft.left != null) 
                    currLeft = currLeft.left;
                else 
                    currLeft = currLeft.right;
            }
        }
        
        // Get leaves
        if (root.left != null || root.right != null)
            addLeaves(res, root);
        
        // Get right boundary
        if (root.right != null) {
            TreeNode currRight = root.right;
            Stack<Integer> stack = new Stack<>();
            while (currRight.left != null || currRight.right != null) {
                stack.push(currRight.val);
                if (currRight.right != null) 
                    currRight = currRight.right;
                else
                    currRight = currRight.left;
            }
            while (!stack.isEmpty())
                res.add(stack.pop());
        }
            
        return res;
    }
    
    public void addLeaves(List<Integer> res, TreeNode curr) {
        if (curr.left == null && curr.right == null)
            res.add(curr.val);
        else {
            if (curr.left != null) 
                addLeaves(res, curr.left);
            if (curr.right != null)
                addLeaves(res, curr.right);
        }
    }
}