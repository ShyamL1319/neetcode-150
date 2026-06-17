class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == '(' || ch=='{' || ch =='['){
                stack.push(ch);
            }else{

                if(stack.isEmpty())  return false;
                
                char p_ch = stack.pop();

                if((ch == '}' && p_ch != '{') ||
                (ch == ')' && p_ch != '(') ||
                (ch == ']' && p_ch != '[')
                ){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
