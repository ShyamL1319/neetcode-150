class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Step 1: Sort to group duplicates together
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        // Every combination we encounter is a valid subset
        result.add(new ArrayList<>(tempList));

        for (int i = start; i < nums.length; i++) {
            // Step 2: Skip duplicates
            // i > start ensures we don't skip the first occurrence of a number 
            // at a new level, only subsequent identical ones at the same level.
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            tempList.add(nums[i]);
            backtrack(result, tempList, nums, i + 1);
            
            // Step 3: Backtrack
            tempList.remove(tempList.size() - 1);
        }
    }
}