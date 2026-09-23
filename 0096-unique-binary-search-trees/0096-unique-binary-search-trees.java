class Solution {
    public int numTrees(int n) {

        int[] dp = new int[n + 1];

        // 0 nodes = 1 possible tree
        dp[0] = 1;

        // 1 node = 1 possible tree
        dp[1] = 1;

        for (int nodes = 2; nodes <= n; nodes++) {

            for (int root = 1; root <= nodes; root++) {

                int left = root - 1;
                int right = nodes - root;

                dp[nodes] += dp[left] * dp[right];
            }
        }

        return dp[n];
    }
}