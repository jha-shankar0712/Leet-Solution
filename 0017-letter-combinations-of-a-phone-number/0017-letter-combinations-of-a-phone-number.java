import java.util.*;

class Solution {

    String[] letters = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();

        if (digits.length() == 0) {
            return ans;
        }

        backtrack(digits, 0, "", ans);

        return ans;
    }

    public void backtrack(String digits, int index,
                           String current, List<String> ans) {

        // Agar poora combination ban gaya
        if (index == digits.length()) {
            ans.add(current);
            return;
        }

        // Current digit nikalo
        int digit = digits.charAt(index) - '0';

        // Us digit ke letters
        String str = letters[digit];

        // Har letter ko try karo
        for (int i = 0; i < str.length(); i++) {

            backtrack(
                digits,
                index + 1,
                current + str.charAt(i),
                ans
            );
        }
    }
}