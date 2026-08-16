public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    int currentArea = dfs(grid, r, c, rows, cols);
                    maxArea = Math.max(maxArea, currentArea);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c, int rows, int cols) {
        // Base case: Out of bounds or water cell
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == 0) {
            return 0;
        }

        // Sink the visited land cell
        grid[r][c] = 0;

        // Sum current cell (1) + area from all 4 directions
        return 1 
            + dfs(grid, r - 1, c, rows, cols) // Up
            + dfs(grid, r + 1, c, rows, cols) // Down
            + dfs(grid, r, c - 1, rows, cols) // Left
            + dfs(grid, r, c + 1, rows, cols); // Right
    }
}