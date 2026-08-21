import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        // Duplicate elements ko easily handle karne ke liye sort
        Arrays.sort(candidates);

        backtrack(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] candidates,
                            int target,
                            int start,
                            List<Integer> current,
                            List<List<Integer>> result) {

        // Target complete
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            // Same level par duplicate skip
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Agar number target se bada hai
            if (candidates[i] > target) {
                break;
            }

            // Choose
            current.add(candidates[i]);

            // i + 1 -> same element dobara use nahi hoga
            backtrack(
                candidates,
                target - candidates[i],
                i + 1,
                current,
                result
            );

            // Undo
            current.remove(current.size() - 1);
        }
    }
}