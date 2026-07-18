class Solution {
    // Principal Tip: Using a String array is faster than a HashMap for fixed 0-9 indices
    private static final String[] MAPPING = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, String digits, int index) {
        // Base case: we've processed all digits
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get the letters for the current digit (e.g., '2' -> "abc")
        String letters = MAPPING[digits.charAt(index) - '0'];
        
        for (char c : letters.toCharArray()) {
            current.append(c);              // Choose
            backtrack(result, current, digits, index + 1); // Explore
            current.deleteCharAt(current.length() - 1);    // Backtrack (Un-choose)
        }
    }
}