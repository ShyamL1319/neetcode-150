public class Solution {
    public void islandsAndTreasure(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();

        // Step 1: Add all treasure chest cells (0) to the queue
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    queue.offer(new int[]{r, c});
                }
            }
        }

        // Direction vectors for moving Up, Down, Left, Right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Step 2: Multi-Source BFS outwards
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                // Only traverse to unvisited land cells (value must be INF / Integer.MAX_VALUE)
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == Integer.MAX_VALUE) {
                    grid[nr][nc] = grid[r][c] + 1; // Distance to nearest treasure
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }
}