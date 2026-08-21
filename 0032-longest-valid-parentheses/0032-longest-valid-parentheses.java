import java.util.*;

class Solution {
    public int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack<>();

        // Base index
        stack.push(-1);

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {

                // Opening bracket ka index store karo
                stack.push(i);

            } else {

                // Opening bracket remove karo
                stack.pop();

                // Agar stack empty ho gaya
                if (stack.isEmpty()) {

                    // New base index
                    stack.push(i);

                } else {

                    // Valid substring ki length
                    int length = i - stack.peek();

                    maxLength = Math.max(maxLength, length);
                }
            }
        }

        return maxLength;
    }
}