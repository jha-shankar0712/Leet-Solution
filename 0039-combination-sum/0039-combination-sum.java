import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] candidates,
                           int target,
                           int index,
                           List<Integer> current,
                           List<List<Integer>> result) {

        // Target complete ho gaya
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Target cross ho gaya
        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            // Current number choose karo
            current.add(candidates[i]);

            // Same number dobara use kar sakte hain
            backtrack(
                candidates,
                target - candidates[i],
                i,
                current,
                result
            );

            // Backtrack
            current.remove(current.size() - 1);
        }
    }
}