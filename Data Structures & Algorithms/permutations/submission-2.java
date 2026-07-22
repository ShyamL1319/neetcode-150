class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Convert to list for easier manipulation if needed, 
        // but working with the array is faster.
        backtrack(nums, 0, result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<List<Integer>> result) {
        // Base case: if we've reached the end of the array, we have a complete permutation
        if (start == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) permutation.add(num);
            result.add(permutation);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            // Swap the current element with the 'start' element
            swap(nums, start, i);
            
            // Recurse for the next position
            backtrack(nums, start + 1, result);
            
            // Backtrack: Restore the original order for the next iteration
            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
