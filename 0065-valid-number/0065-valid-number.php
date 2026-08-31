class Solution {

    function isNumber($s) {

        return preg_match(
            '/^[+-]?((\d+\.?\d*)|(\.\d+))([eE][+-]?\d+)?$/',
            $s
        ) === 1;
    }
}