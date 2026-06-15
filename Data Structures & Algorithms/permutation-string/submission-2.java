class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        
        // Edge case: s1 cannot be longer than s2
        if (len1 > len2) return false;
        
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        
        // 1. Build the frequency arrays for the initial window
        for (int i = 0; i < len1; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }
        
        // 2. Slide the window across s2
        for (int i = len1; i < len2; i++) {
            // Check if the previous window was a match
            if (Arrays.equals(s1Count, s2Count)) {
                return true;
            }
            
            // Slide window: Add the new character on the right
            s2Count[s2.charAt(i) - 'a']++;
            
            // Slide window: Remove the old character from the left
            s2Count[s2.charAt(i - len1) - 'a']--;
        }
        
        // 3. Check the very last window after the loop finishes
        return Arrays.equals(s1Count, s2Count);
    }
}
