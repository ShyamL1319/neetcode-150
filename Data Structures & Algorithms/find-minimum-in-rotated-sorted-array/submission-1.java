class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // The minimum is in the right side
                left = mid + 1;
            } else {
                // The minimum is at mid or to the left
                right = mid;
            }
        }
        // After the loop, left === right, pointing to the minimum
        return nums[left];
    }
}
