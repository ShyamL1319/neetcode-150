class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Start with the first string as the potential prefix
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            // Keep shortening the prefix until strs[i] starts with it
            // indexOf returns 0 if prefix is at the start of strs[i]
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                
                // If prefix is reduced to nothing, return empty
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}