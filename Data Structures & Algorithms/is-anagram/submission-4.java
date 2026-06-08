class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int n = s.length();
        int numCharCounts[] = new int[26];

        for(int i =0; i<n; i++){
            numCharCounts[s.charAt(i) - 'a']++;
            numCharCounts[t.charAt(i) - 'a']--;
        }

        for(int cnt : numCharCounts){
            if(cnt != 0) return false;
        }

        return true;

    }
}
