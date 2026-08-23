class Solution {
    public boolean isMatch(String s, String p) {

        int i = 0;
        int j = 0;

        int star = -1;
        int match = 0;

        while (i < s.length()) {

            // Normal character or '?'
            if (j < p.length() &&
                (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {

                i++;
                j++;
            }

            // Found '*'
            else if (j < p.length() && p.charAt(j) == '*') {

                star = j;
                match = i;

                j++;
            }

            // Mismatch, but we have seen '*'
            else if (star != -1) {

                j = star + 1;
                match++;
                i = match;
            }

            // No '*' available
            else {
                return false;
            }
        }

        // Remaining characters in pattern must all be '*'
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }

        return j == p.length();
    }
}