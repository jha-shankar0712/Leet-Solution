class Solution {
    public int strStr(String haystack, String needle) {

        int n = haystack.length();
        int m = needle.length();

        // Har possible starting index check karo
        for (int i = 0; i <= n - m; i++) {

            int j = 0;

            // Needle ke characters match karo
            while (j < m &&
                   haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            // Puri needle match ho gayi
            if (j == m) {
                return i;
            }
        }

        return -1;
    }
}