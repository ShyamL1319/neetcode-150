public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        // 1. Sort to handle duplicates and pruning
        Arrays.sort(candidates);
        backtrack(results, new ArrayList<>(), candidates, target, 0);
        return results;
    }

    private void backtrack(List<List<Integer>> results, List<Integer> tempList, 
                           int[] candidates, int remain, int start) {
        if (remain == 0) {
            results.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // 2. Pruning: If the current number is greater than what's left, 
            // no need to check further because the array is sorted.
            if (candidates[i] > remain) break;

            // 3. Skip duplicates: Only pick the first instance of a duplicate 
            // at this level of recursion.
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            tempList.add(candidates[i]);
            // i + 1 because we can only use each element once
            backtrack(results, tempList, candidates, remain - candidates[i], i + 1);
            // 4. Backtrack: Remove the last element to try the next number
            tempList.remove(tempList.size() - 1);
        }
    }
}