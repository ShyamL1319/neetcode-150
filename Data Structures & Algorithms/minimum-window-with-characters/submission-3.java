class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int l = 0;
        int r = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        int minLength = Integer.MAX_VALUE;
        int sI = -1;
        int cnt = 0;
        for(char ch : t.toCharArray()){
            hm.put(ch, hm.getOrDefault(ch, 0)+1);
        }
        while(r < n){
            char ch = s.charAt(r);
            if(hm.getOrDefault(ch, 0) > 0){
                cnt+=1;
            }
            hm.put(ch, hm.getOrDefault(ch, 0)-1);
            while(cnt == m){
                if(r-l+1 <= minLength){
                    minLength = r-l+1;
                    sI = l;
                }
                char ch2 = s.charAt(l);
                hm.put(ch2, hm.getOrDefault(ch2, 0)+1);
                if(hm.getOrDefault(ch2, 0) > 0) cnt-=1;
                l+=1;
            }
            r+=1;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(sI, sI+minLength);
    }
}
