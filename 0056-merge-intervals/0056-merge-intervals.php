
class Solution {

    function merge($intervals) {

        // Start time ke according sort
        usort($intervals, function($a, $b) {
            return $a[0] - $b[0];
        });

        $result = [];

        foreach ($intervals as $interval) {

            // Agar result empty hai
            // ya current interval overlap nahi karta
            if (empty($result) || $interval[0] > $result[count($result) - 1][1]) {

                $result[] = $interval;

            } else {

                // Overlapping interval ko merge karo
                $result[count($result) - 1][1] =
                    max(
                        $result[count($result) - 1][1],
                        $interval[1]
                    );
            }
        }

        return $result;
    }
}

