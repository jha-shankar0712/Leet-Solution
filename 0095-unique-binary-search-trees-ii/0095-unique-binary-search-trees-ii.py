class Solution:
    def generateTrees(self, n):

        def build(start, end):

            result = []

            # No nodes
            if start > end:
                return [None]

            # Try every value as root
            for root_value in range(start, end + 1):

                # All possible left subtrees
                left_trees = build(start, root_value - 1)

                # All possible right subtrees
                right_trees = build(root_value + 1, end)

                # Combine every left tree with every right tree
                for left in left_trees:
                    for right in right_trees:

                        root = TreeNode(root_value)

                        root.left = left
                        root.right = right

                        result.append(root)

            return result

        return build(1, n)