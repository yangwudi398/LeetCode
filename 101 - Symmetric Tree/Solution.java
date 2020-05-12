class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isReverse(root.left, root.right);
    }
    
    private boolean isReverse(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left != null && right == null)
            return false;
        if (left == null && right != null)
            return false;
        if (left.val != right.val)
            return false;
        return isReverse(left.left, right.right) && isReverse(left.right, right.left);
    }
}