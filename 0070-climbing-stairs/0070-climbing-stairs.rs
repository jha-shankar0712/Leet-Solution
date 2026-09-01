impl Solution {
    pub fn climb_stairs(n: i32) -> i32 {
        if n <= 2 {
            return n;
        }

        let mut first = 1;
        let mut second = 2;

        for _ in 3..=n {
            let third = first + second;
            first = second;
            second = third;
        }

        second
    }
}