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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < preorder.length; i++)
            queue.offer(preorder[i]);
        
        TreeNode root = new TreeNode();
        buildTree(queue, inorder, root, 0, inorder.length);
        
        return root;
    }
    
    private void buildTree(Deque<Integer> queue, int[] inorder, TreeNode root, int start, int end) {
        for (int i = start; i < end; i++) {
            if (inorder[i] == queue.peek()) {
                root.val = queue.poll();
                
                if (i > start) {
                    TreeNode left = new TreeNode();
                    root.left = left;
                    buildTree(queue, inorder, left, start, i);
                }
                if (i < end - 1) {
                    TreeNode right = new TreeNode();
                    root.right = right;
                    buildTree(queue, inorder, right, i + 1, end);
                }
                
                break;
            }
        }
    }
}