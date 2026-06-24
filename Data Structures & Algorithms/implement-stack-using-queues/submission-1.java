class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    // Pushes element x to the top of the stack.
    public void push(int x) {
        // 1. Push the new element into the helper queue
        q2.add(x);
        
        // 2. Empty all existing elements from q1 into q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        
        // 3. Swap the references of q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    // Removes the element on the top of the stack and returns it.
    public int pop() {
        return q1.remove();
    }
    
    // Returns the element on the top of the stack.
    public int top() {
        return q1.peek();
    }
    
    // Returns true if the stack is empty, false otherwise.
    public boolean empty() {
        return q1.isEmpty();
    }
}