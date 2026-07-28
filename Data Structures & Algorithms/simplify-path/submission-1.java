class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        
        // Split by '/' to get individual directory tokens
        String[] components = path.split("/");
        
        for (String dir : components) {
            // Skip empty tokens (from '//') or '.' (current directory)
            if (dir.isEmpty() || dir.equals(".")) {
                continue;
            }
            
            if (dir.equals("..")) {
                // Go up one level if possible
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Valid directory name (including '...')
                stack.push(dir);
            }
        }
        
        // Reconstruct the canonical path
        StringBuilder canonicalPath = new StringBuilder();
        for (String dir : stack) {
            canonicalPath.append("/").append(dir);
        }
        
        // If the stack was empty, return "/" (root directory)
        return canonicalPath.length() == 0 ? "/" : canonicalPath.toString();
    }
}