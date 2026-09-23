class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        int m = s1.length();
        int n = s2.length();

        // Length must match
        if (m + n != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[m + 1][n + 1];

        // Empty + empty = valid
        dp[0][0] = true;

        for (int i = 0; i <= m; i++) {

            for (int j = 0; j <= n; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }

                // Take character from s1
                if (i > 0 &&
                    dp[i - 1][j] &&
                    s1.charAt(i - 1) == s3.charAt(i + j - 1)) {

                    dp[i][j] = true;
                }

                // Take character from s2
                if (j > 0 &&
                    dp[i][j - 1] &&
                    s2.charAt(j - 1) == s3.charAt(i + j - 1)) {

                    dp[i][j] = true;
                }
            }
        }

        return dp[m][n];
    }
}