class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(hm.containsKey(ch)){
                left = Math.max(left, hm.get(ch)+1);
            }
            hm.put(ch, i);
            maxLen = Math.max(i-left+1, maxLen);
        }

        return maxLen;
    }
}
