class Solution {

    function getPermutation($n, $k) {

        // Available numbers
        $numbers = [];

        for ($i = 1; $i <= $n; $i++) {
            $numbers[] = $i;
        }

        // Convert k to 0-based index
        $k--;

        $result = "";

        // Factorial of n - 1
        $factorial = 1;
        for ($i = 1; $i < $n; $i++) {
            $factorial *= $i;
        }

        for ($i = $n; $i > 0; $i--) {

            // Find which block k belongs to
            $index = intdiv($k, $factorial);

            // Pick that number
            $result .= $numbers[$index];

            // Remove selected number
            array_splice($numbers, $index, 1);

            // Update k
            $k = $k % $factorial;

            // Update factorial
            if ($i > 1) {
                $factorial = intdiv($factorial, $i - 1);
            }
        }

        return $result;
    }
}