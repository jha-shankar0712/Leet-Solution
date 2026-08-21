class Solution {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {

        // Empty cell find karo
        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                if (board[row][col] == '.') {

                    // 1 se 9 tak try karo
                    for (char num = '1'; num <= '9'; num++) {

                        if (isValid(board, row, col, num)) {

                            // Number place karo
                            board[row][col] = num;

                            // Aage solve karo
                            if (solve(board)) {
                                return true;
                            }

                            // Solution nahi mila -> backtrack
                            board[row][col] = '.';
                        }
                    }

                    // Koi number work nahi kiya
                    return false;
                }
            }
        }

        // Koi empty cell nahi bacha
        return true;
    }

    private boolean isValid(char[][] board,
                             int row,
                             int col,
                             char num) {

        // Row check
        for (int c = 0; c < 9; c++) {

            if (board[row][c] == num) {
                return false;
            }
        }

        // Column check
        for (int r = 0; r < 9; r++) {

            if (board[r][col] == num) {
                return false;
            }
        }

        // 3x3 box check
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int r = startRow; r < startRow + 3; r++) {

            for (int c = startCol; c < startCol + 3; c++) {

                if (board[r][c] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}