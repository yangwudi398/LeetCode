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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;
        
        List<List<Integer>> tree = new ArrayList<>();
        if (root == null)
            return tree;
        
        while (!queue.isEmpty()) {
            int currSize = queue.size();
            Stack<TreeNode> stack = new Stack<>();
            List<Integer> layer = new ArrayList<>();
            
            for (int i = 0; i < currSize; i++) {
                TreeNode currNode = queue.poll();
                layer.add(currNode.val);
                    
                if (leftToRight) {
                    if (currNode.left != null)
                        stack.push(currNode.left);
                    if (currNode.right != null)
                        stack.push(currNode.right);
                } else {
                    if (currNode.right != null)
                        stack.push(currNode.right);
                    if (currNode.left != null)
                        stack.push(currNode.left);
                }
            }
            
            tree.add(layer);
            
            leftToRight = !leftToRight;
            
            while (!stack.isEmpty())
                queue.offer(stack.pop());
        }
        
        return tree;
    }
}