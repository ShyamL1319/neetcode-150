class Solution {

    private static class TrieNode {
        private final TrieNode[] children = new TrieNode[26];
        private String word = null;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);

        int rows = board.length;
        int cols = board[0].length;

        // Start DFS from every cell in the grid
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int index = board[r][c] - 'a';
                if (root.children[index] != null) {
                    dfs(board, r, c, root, result);
                }
            }
        }

        return result;
    }

    private void dfs(char[][] board, int r, int c, TrieNode parent, List<String> result) {
        char ch = board[r][c];
        int index = ch - 'a';
        TrieNode node = parent.children[index];

        if (node == null) {
            return;
        }

        // Match found
        if (node.word != null) {
            result.add(node.word);
            node.word = null; // Prevent duplicate additions
        }

        // Mark cell as visited
        board[r][c] = '#';

        // 4 Directional movements: Up, Down, Left, Right
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && board[nr][nc] != '#') {
                dfs(board, nr, nc, node, result);
            }
        }

        // Backtrack: Restore original character
        board[r][c] = ch;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode node = root;
            for (char ch : w.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.word = w; // Store full word at the terminal node
        }
        return root;
    }
}
