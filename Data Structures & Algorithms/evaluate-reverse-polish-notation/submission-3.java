class Solution {
    public int evalRPN(String[] tokens) { 
        // Create a stack to store numbers
        Stack<Integer> stack = new Stack<>(); 
        // Loop through each token in the input
        for (String token : tokens) { 
            // Check if the token is an operator
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) { 
                // Pop the top two numbers from the stack
                int b = stack.pop(); 
                int a = stack.pop(); 
                int result = 0; 
                // Apply the operator
                if (token.equals("+")) result = a + b; 
                // Add
                else if (token.equals("-")) result = a - b; 
                // Subtract
                else if (token.equals("*")) result = a * b; 
                // Multiply
                else if (token.equals("/")) result = a / b; 
                // Divide (integer division)
                // Push the result back to the stack
                stack.push(result); 
            } else { 
                // If it's a number, parse and push to stack
                stack.push(Integer.parseInt(token)); 
            } 
        }
        // The result is the only value left in the stack
        return stack.pop(); 
    }
}
