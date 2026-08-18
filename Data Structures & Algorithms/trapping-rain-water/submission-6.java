class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int prefMax[] = new int[n];
        int suffMax[] = new int[n];

        for (int i = 0; i < n; i++) {
            if (i != 0) {
                prefMax[i] = Math.max(prefMax[i - 1], height[i]);
                suffMax[n-i-1] = Math.max(suffMax[n - i], height[n - i - 1]);
            } else {
                prefMax[0] = height[i];
                suffMax[n - i - 1] = height[n - i - 1];
            }
        }
        int trappedWater = 0;
        for (int i = 1; i < n - 1; i++) {
            trappedWater += Math.max(0, Math.min(prefMax[i - 1], suffMax[i + 1]) - height[i]);
        }

        return trappedWater;
    }
}
