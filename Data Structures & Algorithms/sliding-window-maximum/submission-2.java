public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int ri = 0; // result index
        
        // Store indices of elements in the deque
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            // 1. Remove indices that are out of the window [i-k+1, i]
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            
            // 2. Remove smaller elements from the back
            // They will never be the max because the current nums[i] is larger and newer
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            // 3. Add current element's index
            deque.offerLast(i);
            
            // 4. Add the max (front of deque) to result once the first window is full
            if (i >= k - 1) {
                result[ri++] = nums[deque.peekFirst()];
            }
        }
        
        return result;
    }
}