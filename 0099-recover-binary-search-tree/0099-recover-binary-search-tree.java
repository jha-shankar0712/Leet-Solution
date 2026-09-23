class Solution {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        inorder(root);

        // Swap the values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode node) {

        if (node == null) {
            return;
        }

        // Left
        inorder(node.left);

        // Current node
        if (prev != null && prev.val > node.val) {

            if (first == null) {
                first = prev;
            }

            second = node;
        }

        prev = node;

        // Right
        inorder(node.right);
    }
}