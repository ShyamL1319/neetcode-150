class MinStack {

    private Stack<Integer> stack; // Stack to store all values
    private Stack<Integer> minStack; // Stack to store current minimums

    public MinStack() {
        stack = new Stack<>(); // Initialize the main stack
        minStack = new Stack<>(); // Initialize the min stack
    }

    public void push(int val) {
        stack.push(val); // Push value onto main stack
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val); // Push value onto min stack if it's the new min
        } else {
            minStack.push(minStack.peek()); // Otherwise, repeat the current min
        }
    }

    public void pop() {
        stack.pop(); // Pop from main stack
        minStack.pop(); // Pop from min stack to keep in sync
    }

    public int top() {
        return stack.peek(); // Return the top value of the main stack
    }

    public int getMin() {
        return minStack.peek(); // Return the top value of the min stack (current min)
    }

}
