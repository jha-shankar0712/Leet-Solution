var exist = function(board, word) {
    let rows = board.length;
    let cols = board[0].length;

    function dfs(r, c, index) {
        // Word completely mil gaya
        if (index === word.length) {
            return true;
        }

        // Boundary check + character check
        if (
            r < 0 ||
            r >= rows ||
            c < 0 ||
            c >= cols ||
            board[r][c] !== word[index]
        ) {
            return false;
        }

        // Cell ko visited mark karo
        let temp = board[r][c];
        board[r][c] = "#";

        // 4 directions
        let found =
            dfs(r + 1, c, index + 1) ||
            dfs(r - 1, c, index + 1) ||
            dfs(r, c + 1, index + 1) ||
            dfs(r, c - 1, index + 1);

        // Backtrack
        board[r][c] = temp;

        return found;
    }

    // Har cell ko starting point maan ke check karo
    for (let r = 0; r < rows; r++) {
        for (let c = 0; c < cols; c++) {
            if (dfs(r, c, 0)) {
                return true;
            }
        }
    }

    return false;
};