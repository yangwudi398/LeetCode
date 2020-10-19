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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0)
            return null;
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < postorder.length; i++)
            stack.push(postorder[i]);
        
        TreeNode root = new TreeNode();
        buildTree(stack, inorder, root, 0, inorder.length);
        
        return root;
    }
    
    private void buildTree(Stack<Integer> postorder, int[] inorder, TreeNode root, int start, int end) {
        for (int i = start; i < end; i++) {
            if (inorder[i] == postorder.peek()) {
                root.val = postorder.pop();
                
                if (i < end - 1) {
                    TreeNode right = new TreeNode();
                    root.right = right;
                    buildTree(postorder, inorder, right, i + 1, end);
                }
                if (i > start) {
                    TreeNode left = new TreeNode();
                    root.left = left;
                    buildTree(postorder, inorder, left, start, i);
                }
                
                break;
            }
        }
    }
}