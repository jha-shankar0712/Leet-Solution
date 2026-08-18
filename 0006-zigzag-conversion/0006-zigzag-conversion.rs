impl Solution {
    pub fn convert(s: String, num_rows: i32) -> String {
        if num_rows == 1 || num_rows as usize >= s.len() {
            return s;
        }

        let rows = num_rows as usize;
        let mut arr = vec![String::new(); rows];

        let mut current_row = 0;
        let mut going_down = false;

        for ch in s.chars() {
            arr[current_row].push(ch);

            if current_row == 0 || current_row == rows - 1 {
                going_down = !going_down;
            }

            if going_down {
                current_row += 1;
            } else {
                current_row -= 1;
            }
        }

        arr.concat()
    }
}