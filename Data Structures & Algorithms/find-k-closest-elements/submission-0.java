class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length - k;

        // Binary search to find the optimal starting index of the subarray
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            // Compare the distance of x from the boundaries of the window
            if (x - arr[mid] > arr[mid + k] - x) {
                low = mid + 1; // Window needs to shift right
            } else {
                high = mid;    // Window needs to shift left or stay here
            }
        }

        // Collect the k elements starting from index 'low'
        List<Integer> result = new ArrayList<>(k);
        for (int i = low; i < low + k; i++) {
            result.add(arr[i]);
        }
        
        return result;
    }
}