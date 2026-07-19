class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>> result = new ArrayList<>();
        boolean[][] dp = new boolean[n][n];

        // Step 1: Precompute all palindromes in O(n^2)
        // dp[i][j] is true if s[i...j] is a palindrome
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = (len <= 2) || dp[i + 1][j - 1];
                }
            }
        }

        backtrack(result, new ArrayList<>(), s, 0, dp);
        return result;
    }

    private void backtrack(List<List<String>> res, List<String> currentPath, String s, int start, boolean[][] dp) {
        if (start == s.length()) {
            res.add(new ArrayList<>(currentPath));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (dp[start][end]) {
                currentPath.add(s.substring(start, end + 1));
                backtrack(res, currentPath, s, end + 1, dp);
                currentPath.remove(currentPath.size() - 1); // Backtrack
            }
        }
    }
}