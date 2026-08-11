public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        
        // Track occupied columns and diagonals
        boolean[] cols = new boolean[n];
        boolean[] mainDiags = new boolean[2 * n]; // r - c + n (offset to avoid negative indices)
        boolean[] antiDiags = new boolean[2 * n]; // r + c
        
        // Initialize an empty board
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        backtrack(0, n, board, cols, mainDiags, antiDiags, result);
        return result;
    }

    private void backtrack(
        int row, 
        int n, 
        char[][] board, 
        boolean[] cols, 
        boolean[] mainDiags, 
        boolean[] antiDiags, 
        List<List<String>> result
    ) {
        if (row == n) {
            result.add(constructBoard(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            int mainIndex = row - col + n;
            int antiIndex = row + col;

            // If column or diagonals are under attack, skip
            if (cols[col] || mainDiags[mainIndex] || antiDiags[antiIndex]) {
                continue;
            }

            // Place queen
            board[row][col] = 'Q';
            cols[col] = true;
            mainDiags[mainIndex] = true;
            antiDiags[antiIndex] = true;

            // Recurse to next row
            backtrack(row + 1, n, board, cols, mainDiags, antiDiags, result);

            // Backtrack (remove queen)
            board[row][col] = '.';
            cols[col] = false;
            mainDiags[mainIndex] = false;
            antiDiags[antiIndex] = false;
        }
    }

    private List<String> constructBoard(char[][] board) {
        List<String> currentBoard = new ArrayList<>();
        for (char[] row : board) {
            currentBoard.add(new String(row));
        }
        return currentBoard;
    }
}