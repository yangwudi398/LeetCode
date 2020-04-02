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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode last = null;
            for (int i = 0; i < size; i++) {
                last = queue.pop();
                if (last.left != null)
                    queue.offer(last.left);
                if (last.right != null)
                    queue.offer(last.right);
            }
            view.add(last.val);
        }
        
        return view;
    }
}