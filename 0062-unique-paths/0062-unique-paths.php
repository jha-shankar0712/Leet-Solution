class Solution {

    function uniquePaths($m, $n) {

        // Create a 1D DP array
        $dp = array_fill(0, $n, 1);

        // Calculate paths row by row
        for ($i = 1; $i < $m; $i++) {

            for ($j = 1; $j < $n; $j++) {

                $dp[$j] = $dp[$j] + $dp[$j - 1];
            }
        }

        return $dp[$n - 1];
    }
}