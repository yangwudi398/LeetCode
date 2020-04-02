/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "[]";
        
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        String ans = "[";
        
        while (!queue.isEmpty()) {
            String subAns = "";
            int countNode = 0;
            
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pop();
                if (node == null) {
                    subAns += "null,";
                } else {
                    subAns += node.val + ",";
                    queue.offer(node.left);
                    queue.offer(node.right);
                    countNode++;
                }
            }
            
            if (countNode > 0)
                ans += subAns;
        }
        
        ans = ans.substring(0, ans.length() - 1) + "]";
        return ans;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 2)
            return null;
        
        data = data.substring(1, data.length() - 1);
        String[] values = data.split(",");
        
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(values[0]));
        queue.offer(root);
        
        int i = 1;
        while (i < values.length) {
            TreeNode curr = queue.pop();
            
            String v1 = values[i];
            if (!v1.equals("null")) {
                TreeNode left = new TreeNode(Integer.valueOf(v1));
                curr.left = left;
                queue.offer(left);
            }
            
            if (i + 1 < values.length) {
                String v2 = values[i+1];
                if (!v2.equals("null")) {
                    TreeNode right = new TreeNode(Integer.valueOf(v2));
                    curr.right = right;
                    queue.offer(right);
                }
            }
            
            i += 2;
        }
        
        return root;
    }
}
