class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int hm[] = new int[26];
        int maxFreq = 0;
        int maxLen = 0;
        int l=0,r=0;

        while(r < n){
            char ch = s.charAt(r);
            hm[ch-'A']++;
            maxFreq = Math.max(maxFreq, hm[ch-'A']);
            if((r-l+1) - maxFreq > k){
                char lchar = s.charAt(l);
                hm[lchar- 'A']--;
                maxFreq = 0;
                l+=1;
            }

            if(r-l+1 - maxFreq <= k ){
                maxLen = Math.max(maxLen, r-l+1);
            }
            r+=1;
        }

        return maxLen;
    }
}
