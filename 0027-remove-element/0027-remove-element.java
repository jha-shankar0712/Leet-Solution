class Solution {
    public int removeElement(int[] nums, int val) {

        int k = 0;

        for (int i = 0; i < nums.length; i++) {

            // Agar current element val nahi hai
            if (nums[i] != val) {

                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}