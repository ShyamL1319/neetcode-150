class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Step 1: Define the search range [low, high]
        int low = 1;
        int high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        int result = high;

        // Step 2: Binary Search for the minimum k
        while (low <= high) {
            int k = low + (high - low) / 2;
            
            if (canFinish(piles, h, k)) {
                result = k;      // This speed works, but can we go slower?
                high = k - 1;
            } else {
                low = k + 1;     // Too slow! Need to increase speed.
            }
        }
        return result;
    }

    // Helper to check if speed 'k' is viable
    private boolean canFinish(int[] piles, int h, int k) {
        long totalHours = 0; // Use long to prevent overflow
        for (int pile : piles) {
            // Calculate ceiling division: ceil(pile / k)
            totalHours += (pile + k - 1) / k;
        }
        return totalHours <= h;
    }
}