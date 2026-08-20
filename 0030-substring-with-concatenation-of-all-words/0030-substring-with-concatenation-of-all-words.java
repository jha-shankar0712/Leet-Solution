import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> ans = new ArrayList<>();

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        if (s.length() < totalLen) {
            return ans;
        }

        // Words ki required frequency
        Map<String, Integer> required = new HashMap<>();

        for (String word : words) {
            required.put(word, required.getOrDefault(word, 0) + 1);
        }

        // Different starting offsets check karo
        for (int offset = 0; offset < wordLen; offset++) {

            int left = offset;
            int count = 0;

            Map<String, Integer> window = new HashMap<>();

            for (int right = offset;
                 right + wordLen <= s.length();
                 right += wordLen) {

                String word = s.substring(right, right + wordLen);

                // Agar word required list mein nahi hai
                if (!required.containsKey(word)) {

                    window.clear();
                    count = 0;
                    left = right + wordLen;

                    continue;
                }

                // Current word window mein add karo
                window.put(
                    word,
                    window.getOrDefault(word, 0) + 1
                );

                count++;

                // Agar current word extra ho gaya
                while (window.get(word) > required.get(word)) {

                    String leftWord =
                        s.substring(left, left + wordLen);

                    window.put(
                        leftWord,
                        window.get(leftWord) - 1
                    );

                    left += wordLen;
                    count--;
                }

                // Sabhi words mil gaye
                if (count == wordCount) {

                    ans.add(left);

                    // Window ko aage move karo
                    String leftWord =
                        s.substring(left, left + wordLen);

                    window.put(
                        leftWord,
                        window.get(leftWord) - 1
                    );

                    left += wordLen;
                    count--;
                }
            }
        }

        return ans;
    }
}