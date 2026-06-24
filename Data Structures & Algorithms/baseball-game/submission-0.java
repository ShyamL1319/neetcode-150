class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> scoreStack = new Stack<>();
        
        for (String op : operations) {
            switch (op) {
                case "+":
                    // Get the top two elements to sum them up
                    int top = scoreStack.pop();
                    int newScore = top + scoreStack.peek();
                    // Push them back in the correct order
                    scoreStack.push(top);
                    scoreStack.push(newScore);
                    break;
                    
                case "D":
                    // Double the last score
                    scoreStack.push(2 * scoreStack.peek());
                    break;
                    
                case "C":
                    // Invalidate/remove the last score
                    scoreStack.pop();
                    break;
                    
                default:
                    // It's an integer score, parse and push it
                    scoreStack.push(Integer.parseInt(op));
                    break;
            }
        }
        
        // Sum all elements remaining in the stack
        int totalSum = 0;
        for (int score : scoreStack) {
            totalSum += score;
        }
        
        return totalSum;
    }
}