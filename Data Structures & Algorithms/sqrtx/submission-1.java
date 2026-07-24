class Solution {
    public int mySqrt(int x) {
        // Base cases: sqrt(0) = 0, sqrt(1) = 1
        if (x < 2) {
            return x;
        }
        
        int left = 2;
        int right = x / 2; // The square root of x >= 4 is always <= x/2
        int ans = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Using division instead of (mid * mid <= x) to prevent integer overflow
            if (mid == x / mid) {
                return mid; 
            } else if (mid < x / mid) {
                ans = mid; // mid is a potential answer, but let's check if a larger one exists
                left = mid + 1;
            } else {
                right = mid - 1; // mid is too big
            }
        }
        
        return ans;
    }
}