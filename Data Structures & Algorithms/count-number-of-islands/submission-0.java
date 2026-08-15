public class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int islandCount = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    islandCount++;
                    dfs(grid, r, c, rows, cols);
                }
            }
        }
        return islandCount;
    }

    private void dfs(char[][] grid, int r, int c, int rows, int cols) {
        grid[r][c] = '0'; // Sink cell

        // Only call recursively if valid & land (saves call stack frames)
        if (r > 0 && grid[r - 1][c] == '1') dfs(grid, r - 1, c, rows, cols);
        if (r + 1 < rows && grid[r + 1][c] == '1') dfs(grid, r + 1, c, rows, cols);
        if (c > 0 && grid[r][c - 1] == '1') dfs(grid, r, c - 1, rows, cols);
        if (c + 1 < cols && grid[r][c + 1] == '1') dfs(grid, r, c + 1, rows, cols);
    }
}