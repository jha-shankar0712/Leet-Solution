import java.util.*;

class Solution {

    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();

        backtrack(ans, "", 0, 0, n);

        return ans;
    }

    public void backtrack(List<String> ans, String current,
                           int open, int close, int n) {

        // Combination complete
        if (current.length() == 2 * n) {
            ans.add(current);
            return;
        }

        // Opening bracket add kar sakte hain
        if (open < n) {
            backtrack(
                ans,
                current + "(",
                open + 1,
                close,
                n
            );
        }

        // Closing bracket tabhi add karenge
        // jab open brackets zyada hon
        if (close < open) {
            backtrack(
                ans,
                current + ")",
                open,
                close + 1,
                n
            );
        }
    }
}