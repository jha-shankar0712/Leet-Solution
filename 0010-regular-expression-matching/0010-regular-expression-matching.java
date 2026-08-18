class Solution {
    public boolean isMatch(String s, String p) {

        int m = s.length();
        int n = p.length();

        // dp[i][j] = whether first i characters of s
        // match first j characters of p
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Empty string matches empty pattern
        dp[0][0] = true;

        // Handle patterns like a*, a*b*, a*b*c*
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                char currentString = s.charAt(i - 1);
                char currentPattern = p.charAt(j - 1);

                // Case 1: Normal character or '.'
                if (currentPattern == '.' ||
                    currentPattern == currentString) {

                    dp[i][j] = dp[i - 1][j - 1];
                }

                // Case 2: '*'
                else if (currentPattern == '*') {

                    // Option 1: '*' matches zero characters
                    dp[i][j] = dp[i][j - 2];

                    // Option 2: '*' matches one or more characters
                    char previousPattern = p.charAt(j - 2);

                    if (previousPattern == '.' ||
                        previousPattern == currentString) {

                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m][n];
    }
}