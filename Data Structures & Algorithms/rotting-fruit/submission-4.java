public class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        Queue<int[]> queue = new ArrayDeque<>();
        int freshCount = 0;
        int minutes = 0;

        // Step 1: Collect initial rotten fruits and count fresh fruits
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }

        // Edge case: No fresh fruit to rot
        if (freshCount == 0) {
            return 0;
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // Step 2: Multi-source BFS layer by layer
        while (!queue.isEmpty() && freshCount > 0) {
            minutes++;
            int size = queue.size(); // Number of rotten oranges in current minute

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];

                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    // Check boundaries and fresh status
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2; // Make fresh fruit rotten
                        freshCount--;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        // Step 3: If fresh fruit remain unreachable, return -1
        return freshCount == 0 ? minutes : -1;
    }
}