class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // A window of size k means we only care about the previous k elements
        Set<Integer> window = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            // If the element is already in the set, we found a duplicate within distance k
            if (window.contains(nums[i])) {
                return true;
            }
            
            window.add(nums[i]);
            
            // Maintain the window size: remove the oldest element if set size > k
            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }
        
        return false;
    }
}