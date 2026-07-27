class Solution {
    public int largestRectangleArea(int[] heights) {
        // Stack to store indices of the histogram bars
        Stack<Integer> stack = new Stack<>(); // Stack to keep indices
        int maxArea = 0; // Variable to keep track of the maximum area
        int n = heights.length; // Length of the heights array

        for (int i = 0; i <= n; i++) { // Iterate through all bars, including a virtual bar at the end
            int h = (i == n) ? 0 : heights[i]; // Height is 0 for the virtual bar, otherwise heights[i]
            while (!stack.isEmpty() && h < heights[stack.peek()]) { // While current bar is lower than the bar at stack top
                int height = heights[stack.pop()]; // Pop the top and get its height
                int width = stack.isEmpty() ? i : i - stack.peek() - 1; // Calculate width
                maxArea = Math.max(maxArea, height * width); // Update maxArea if needed
            }
            stack.push(i); // Push current index to stack
        }
        return maxArea; // Return the maximum area found
    }
}