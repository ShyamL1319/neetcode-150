class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int ast : asteroids) {
            boolean exploded = false;
            
            // Collision condition: top of stack goes right (> 0) and current goes left (< 0)
            while (!stack.isEmpty() && stack.peek() > 0 && ast < 0) {
                int top = stack.peek();
                
                if (Math.abs(ast) > top) {
                    // Top asteroid explodes, current keeps moving left
                    stack.pop();
                    continue; 
                } else if (Math.abs(ast) == top) {
                    // Both explode
                    stack.pop();
                    exploded = true;
                    break;
                } else {
                    // Current asteroid explodes
                    exploded = true;
                    break;
                }
            }
            
            // If the current asteroid didn't explode, add it to the stack
            if (!exploded) {
                stack.push(ast);
            }
        }
        
        // Convert stack to array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return result;
    }
}