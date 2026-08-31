class Solution {

    function uniquePathsWithObstacles($obstacleGrid) {

        $m = count($obstacleGrid);
        $n = count($obstacleGrid[0]);

        // DP array
        $dp = array_fill(0, $n, 0);

        // Starting point
        $dp[0] = 1;

        for ($i = 0; $i < $m; $i++) {

            for ($j = 0; $j < $n; $j++) {

                // If current cell is an obstacle
                if ($obstacleGrid[$i][$j] == 1) {
                    $dp[$j] = 0;
                }
                else if ($j > 0) {
                    $dp[$j] = $dp[$j] + $dp[$j - 1];
                }
            }
        }

        return $dp[$n - 1];
    }
}