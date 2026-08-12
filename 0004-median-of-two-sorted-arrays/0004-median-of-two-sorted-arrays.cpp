class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {

        // Binary search smaller array
        if (nums1.size() > nums2.size()) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.size();
        int n = nums2.size();

        int low = 0;
        int high = m;

        while (low <= high) {

            // Partition of nums1
            int cut1 = (low + high) / 2;

            // Partition of nums2
            int cut2 = (m + n + 1) / 2 - cut1;

            // Left and right values
            int left1 = (cut1 == 0) ? INT_MIN : nums1[cut1 - 1];
            int right1 = (cut1 == m) ? INT_MAX : nums1[cut1];

            int left2 = (cut2 == 0) ? INT_MIN : nums2[cut2 - 1];
            int right2 = (cut2 == n) ? INT_MAX : nums2[cut2];

            // Correct partition
            if (left1 <= right2 && left2 <= right1) {

                // Odd total length
                if ((m + n) % 2 == 1) {
                    return max(left1, left2);
                }

                // Even total length
                return (max(left1, left2) + min(right1, right2)) / 2.0;
            }

            // nums1 partition is too far right
            else if (left1 > right2) {
                high = cut1 - 1;
            }

            // nums1 partition is too far left
            else {
                low = cut1 + 1;
            }
        }

        return 0.0;
    }
};