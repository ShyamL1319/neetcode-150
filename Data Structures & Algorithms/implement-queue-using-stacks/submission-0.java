class MyQueue {
    private Stack<Integer> input;
    private Stack<Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }
    
    // Pushes element x to the back of the queue.
    public void push(int x) {
        input.push(x);
    }
    
    // Removes the element from the front of the queue and returns it.
    public int pop() {
        shiftStacks();
        return output.pop();
    }
    
    // Returns the element at the front of the queue.
    public int peek() {
        shiftStacks();
        return output.peek();
    }
    
    // Returns true if the queue is empty, false otherwise.
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }

    // Helper method to move elements from input to output when needed
    private void shiftStacks() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */