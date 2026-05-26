class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        // Map to store (prefixSum, frequency)
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        
        // Base case: a prefix sum of 0 has occurred once
        prefixSumMap.put(0, 1);
        
        for (int num : nums) {
            currentSum += num;
            
            // If (currentSum - k) exists, it means we found subarrays summing to k
            if (prefixSumMap.containsKey(currentSum - k)) {
                count += prefixSumMap.get(currentSum - k);
            }
            
            // Update the map with the current prefix sum
            prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }
}