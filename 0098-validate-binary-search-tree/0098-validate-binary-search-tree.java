class Solution {
    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean check(TreeNode node, long min, long max) {

        if (node == null) {
            return true;
        }

        // Current node must be inside the allowed range
        if (node.val <= min || node.val >= max) {
            return false;
        }

        // Left subtree
        if (!check(node.left, min, node.val)) {
            return false;
        }

        // Right subtree
        if (!check(node.right, node.val, max)) {
            return false;
        }

        return true;
    }
}