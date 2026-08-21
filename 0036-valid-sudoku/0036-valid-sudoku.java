class Solution {
    public boolean isValidSudoku(char[][] board) {

        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int r = 0; r < 9; r++) {

            for (int c = 0; c < 9; c++) {

                // Empty cell
                if (board[r][c] == '.') {
                    continue;
                }

                // '1' -> 0, '2' -> 1, ..., '9' -> 8
                int num = board[r][c] - '1';

                // Current 3x3 box find karo
                int box = (r / 3) * 3 + (c / 3);

                // Duplicate check
                if (rows[r][num] ||
                    cols[c][num] ||
                    boxes[box][num]) {

                    return false;
                }

                // Mark as used
                rows[r][num] = true;
                cols[c][num] = true;
                boxes[box][num] = true;
            }
        }

        return true;
    }
}