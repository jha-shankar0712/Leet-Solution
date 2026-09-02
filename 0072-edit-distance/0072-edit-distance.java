class Solution {
    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        // word1 -> empty string
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        // empty string -> word2
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // Characters same hain
                    dp[i][j] = dp[i - 1][j - 1];
                } 
                else {
                    // Insert, Delete, Replace
                    dp[i][j] = 1 + Math.min(
                        dp[i - 1][j], 
                        Math.min(
                            dp[i][j - 1],
                            dp[i - 1][j - 1]
                        )
                    );
                }
            }
        }

        return dp[m][n];
    }
}