class Solution {

    public int totalNQueens(int n) {

        boolean[] cols = new boolean[n];

        boolean[] diag1 = new boolean[2 * n];

        boolean[] diag2 = new boolean[2 * n];

        return backtrack(0, n, cols, diag1, diag2);
    }

    private int backtrack(
        int row,
        int n,
        boolean[] cols,
        boolean[] diag1,
        boolean[] diag2
    ) {

        // All queens placed successfully
        if (row == n) {
            return 1;
        }

        int count = 0;

        // Try every column
        for (int col = 0; col < n; col++) {

            int d1 = row - col + n;
            int d2 = row + col;

            // Position is already attacked
            if (cols[col] || diag1[d1] || diag2[d2]) {
                continue;
            }

            // Place queen
            cols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            // Move to next row
            count += backtrack(
                row + 1,
                n,
                cols,
                diag1,
                diag2
            );

            // Backtrack
            cols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }

        return count;
    }
}