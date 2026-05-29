class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int k = 0; // Pointer for the last unique element found

        for (int i = 1; i < nums.length; i++) {
            // If current element is different from the last unique element
            if (nums[i] != nums[k]) {
                k++;
                nums[k] = nums[i]; // Move the unique element forward
            }
        }

        // k is an index, so the number of unique elements is k + 1
        return k + 1;
    }
}