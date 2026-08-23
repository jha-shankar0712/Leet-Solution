import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            // Frequency of 26 lowercase letters
            int[] count = new int[26];

            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            // Convert frequency array into a key
            StringBuilder key = new StringBuilder();

            for (int num : count) {
                key.append('#');
                key.append(num);
            }

            // Add string to its anagram group
            map.computeIfAbsent(key.toString(), k -> new ArrayList<>())
               .add(str);
        }

        return new ArrayList<>(map.values());
    }
}