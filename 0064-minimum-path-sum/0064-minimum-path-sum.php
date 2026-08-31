class Solution {

    function minPathSum($grid) {

        $m = count($grid);
        $n = count($grid[0]);

        // DP array
        $dp = array_fill(0, $n, 0);

        for ($i = 0; $i < $m; $i++) {

            for ($j = 0; $j < $n; $j++) {

                // Starting cell
                if ($i == 0 && $j == 0) {
                    $dp[$j] = $grid[$i][$j];
                }

                // First row: only move right
                else if ($i == 0) {
                    $dp[$j] = $dp[$j - 1] + $grid[$i][$j];
                }

                // First column: only move down
                else if ($j == 0) {
                    $dp[$j] = $dp[$j] + $grid[$i][$j];
                }

                // Other cells: minimum of top and left
                else {
                    $dp[$j] = min($dp[$j], $dp[$j - 1]) + $grid[$i][$j];
                }
            }
        }

        return $dp[$n - 1];
    }
}