class Solution {

    private int postorderIndex;
    private HashMap<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        postorderIndex = postorder.length - 1;

        // Store inorder value -> index
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int left, int right) {

        // No elements
        if (left > right) {
            return null;
        }

        // Last element of postorder is root
        int rootValue = postorder[postorderIndex--];

        TreeNode root = new TreeNode(rootValue);

        // Find root in inorder
        int rootIndex = inorderMap.get(rootValue);

        // IMPORTANT:
        // Build RIGHT first
        root.right = build(postorder, rootIndex + 1, right);

        // Then LEFT
        root.left = build(postorder, left, rootIndex - 1);

        return root;
    }
}