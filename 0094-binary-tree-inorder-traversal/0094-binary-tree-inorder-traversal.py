class Solution:
    def inorderTraversal(self, root):
        result = []

        def inorder(node):
            if node is None:
                return

            # Left
            inorder(node.left)

            # Root
            result.append(node.val)

            # Right
            inorder(node.right)

        inorder(root)

        return result