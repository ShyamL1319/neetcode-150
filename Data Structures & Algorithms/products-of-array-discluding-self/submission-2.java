class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int pref[] = new int[n];
        int suff[] = new int[n];
        pref[0] = nums[0];
        suff[n-1] = nums[n-1];
        for(int i=1; i<n; i++){
            pref[i] = nums[i] * pref[i-1];
            suff[n-i-1] = suff[n-i] * nums[n-i-1];
        }

        int res[] = new int[n];
        res[0] = suff[1];
        res[n-1] = pref[n-2];
        for(int i=1; i<n-1; i++){
            res[i] = pref[i-1] * suff[i+1];
        }
        return res;
    }
}  
