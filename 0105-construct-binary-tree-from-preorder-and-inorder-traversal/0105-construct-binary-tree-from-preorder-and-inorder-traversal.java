class Solution {

    private int preorderIndex = 0;

    private HashMap<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // Store inorder value -> index
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {

        // No elements
        if (left > right) {
            return null;
        }

        // First preorder element is root
        int rootValue = preorder[preorderIndex++];

        TreeNode root = new TreeNode(rootValue);

        // Find root position in inorder
        int rootIndex = inorderMap.get(rootValue);

        // Build left subtree
        root.left = build(preorder, left, rootIndex - 1);

        // Build right subtree
        root.right = build(preorder, rootIndex + 1, right);

        return root;
    }
}