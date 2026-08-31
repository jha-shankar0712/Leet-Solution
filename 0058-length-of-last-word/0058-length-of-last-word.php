class Solution {

    function lengthOfLastWord($s) {

        // Remove spaces from the end
        $s = rtrim($s);

        // Split the string into words
        $words = explode(" ", $s);

        // Return length of last word
        return strlen(end($words));
    }
}