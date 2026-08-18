class Solution {
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int maxWater = 0;

        while (left < right) {

            // Width
            int width = right - left;

            // Smaller height decides the water level
            int h = Math.min(height[left], height[right]);

            // Calculate current area
            int area = width * h;

            // Update maximum
            maxWater = Math.max(maxWater, area);

            // Move the smaller line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}