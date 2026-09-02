import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        // Path ko "/" ke basis par split karna
        String[] parts = path.split("/");

        for (String part : parts) {

            // Empty string ya "." ko ignore karo
            if (part.equals("") || part.equals(".")) {
                continue;
            }

            // ".." means parent directory
            else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }

            // Normal directory/file name
            else {
                stack.push(part);
            }
        }

        // Stack ko canonical path mein convert karo
        StringBuilder result = new StringBuilder();

        for (String dir : stack) {
            result.append("/");
            result.append(dir);
        }

        // Agar stack empty hai → root directory
        if (result.length() == 0) {
            return "/";
        }

        return result.toString();
    }
}