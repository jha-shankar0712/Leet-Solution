class Solution {
    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Target mil gaya
            if (nums[mid] == target) {
                return mid;
            }

            // Target right side mein hoga
            if (nums[mid] < target) {
                left = mid + 1;
            }

            // Target left side mein hoga
            else {
                right = mid - 1;
            }
        }

        // Target nahi mila
        // left hi correct insertion position hai
        return left;
    }
}