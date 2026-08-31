class Solution {

    function generateMatrix($n) {

        // Create n x n matrix
        $matrix = array_fill(0, $n, array_fill(0, $n, 0));

        $top = 0;
        $bottom = $n - 1;
        $left = 0;
        $right = $n - 1;

        $num = 1;

        while ($top <= $bottom && $left <= $right) {

            // 1. Left to Right
            for ($i = $left; $i <= $right; $i++) {
                $matrix[$top][$i] = $num++;
            }
            $top++;

            // 2. Top to Bottom
            for ($i = $top; $i <= $bottom; $i++) {
                $matrix[$i][$right] = $num++;
            }
            $right--;

            // 3. Right to Left
            if ($top <= $bottom) {
                for ($i = $right; $i >= $left; $i--) {
                    $matrix[$bottom][$i] = $num++;
                }
                $bottom--;
            }

            // 4. Bottom to Top
            if ($left <= $right) {
                for ($i = $bottom; $i >= $top; $i--) {
                    $matrix[$i][$left] = $num++;
                }
                $left++;
            }
        }

        return $matrix;
    }
}