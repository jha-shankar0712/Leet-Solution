impl Solution {
    pub fn full_justify(words: Vec<String>, max_width: i32) -> Vec<String> {
        let max_width = max_width as usize;
        let mut result = Vec::new();
        let mut i = 0;

        while i < words.len() {
            let mut j = i;
            let mut line_len = 0;

            // Find how many words can fit in this line
            while j < words.len() {
                let word_len = words[j].len();

                if line_len + word_len + (j - i) > max_width {
                    break;
                }

                line_len += word_len;
                j += 1;
            }

            let word_count = j - i;
            let is_last_line = j == words.len();

            // Last line OR only one word
            if is_last_line || word_count == 1 {
                let mut line = String::new();

                for k in i..j {
                    if k > i {
                        line.push(' ');
                    }

                    line.push_str(&words[k]);
                }

                // Add remaining spaces at the end
                while line.len() < max_width {
                    line.push(' ');
                }

                result.push(line);
            } else {
                // Normal fully-justified line
                let total_spaces = max_width - line_len;
                let gaps = word_count - 1;

                let space_between = total_spaces / gaps;
                let extra_spaces = total_spaces % gaps;

                let mut line = String::new();

                for k in i..j {
                    line.push_str(&words[k]);

                    if k < j - 1 {
                        // Left gaps get one extra space
                        let spaces = space_between
                            + if k - i < extra_spaces { 1 } else { 0 };

                        for _ in 0..spaces {
                            line.push(' ');
                        }
                    }
                }

                result.push(line);
            }

            i = j;
        }

        result
    }
}
