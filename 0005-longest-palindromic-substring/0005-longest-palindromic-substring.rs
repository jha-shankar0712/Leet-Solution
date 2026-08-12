impl Solution {
    pub fn longest_palindrome(s: String) -> String {
        let chars: Vec<char> = s.chars().collect();
        let n = chars.len();

        let mut start = 0;
        let mut end = 0;

        fn expand(chars: &[char], mut left: i32, mut right: i32) -> (usize, usize) {
            let n = chars.len() as i32;

            while left >= 0
                && right < n
                && chars[left as usize] == chars[right as usize]
            {
                left -= 1;
                right += 1;
            }

            ((left + 1) as usize, right as usize)
        }

        for i in 0..n {
            // Odd length palindrome
            let (l1, r1) = expand(&chars, i as i32, i as i32);

            // Even length palindrome
            let (l2, r2) = expand(&chars, i as i32, i as i32 + 1);

            if r1 - l1 > end - start {
                start = l1;
                end = r1;
            }

            if r2 - l2 > end - start {
                start = l2;
                end = r2;
            }
        }

        chars[start..end].iter().collect()
    }
}