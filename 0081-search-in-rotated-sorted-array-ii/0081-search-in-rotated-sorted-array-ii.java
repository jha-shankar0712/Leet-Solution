class Solution {
    public boolean search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Target mil gaya
            if (nums[mid] == target) {
                return true;
            }

            // Duplicate values handle karo
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            }

            // Left half sorted hai
            else if (nums[left] <= nums[mid]) {

                // Target left sorted part mein hai
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                }
                // Otherwise right side mein search
                else {
                    left = mid + 1;
                }
            }

            // Right half sorted hai
            else {

                // Target right sorted part mein hai
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                }
                // Otherwise left side mein search
                else {
                    right = mid - 1;
                }
            }
        }

        return false;
    }
}