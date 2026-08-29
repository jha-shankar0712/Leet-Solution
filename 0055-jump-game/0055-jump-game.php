
class Solution {

    function canJump($nums) {

        $maxReach = 0;

        for ($i = 0; $i < count($nums); $i++) {

            if ($i > $maxReach) {
                return false;
            }

            $maxReach = max($maxReach, $i + $nums[$i]);

            if ($maxReach >= count($nums) - 1) {
                return true;
            }
        }

        return true;
    }
}

