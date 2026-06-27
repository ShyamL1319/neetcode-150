class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Initialize the result array with zeros
        int[] result = new int[temperatures.length];
        // Stack to keep indices of unresolved days
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        // Iterate through each day's temperature
        for (int i = 0; i < temperatures.length; i++) {
            // While stack is not empty and current temperature is higher than the temperature at the index on top of the stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // Pop the index from the stack
                int prevIndex = stack.pop();
                // Calculate the number of days waited and update the result
                result[prevIndex] = i - prevIndex;
            }
            // Push the current index onto the stack
            stack.push(i);
        }
        // Return the result array
        return result;
    }
}