impl Solution {
    pub fn my_sqrt(x: i32) -> i32 {
        if x < 2 {
            return x;
        }

        let mut left = 1;
        let mut right = x / 2;
        let mut answer = 0;

        while left <= right {
            let mid = left + (right - left) / 2;

            // mid * mid can overflow, so use division
            if mid <= x / mid {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        answer
    }
}