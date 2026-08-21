class Solution {
    public void nextPermutation(int[] nums) {

        int n = nums.length;

        // Step 1: First decreasing element find karo
        int i = n - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: Agar decreasing element mila
        if (i >= 0) {

            int j = n - 1;

            // nums[i] se just bada element find karo
            while (nums[j] <= nums[i]) {
                j--;
            }

            // Swap
            swap(nums, i, j);
        }

        // Step 3: i ke baad ka part reverse karo
        reverse(nums, i + 1, n - 1);
    }

    // Swap function
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Reverse function
    private void reverse(int[] nums, int left, int right) {

        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}