class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        int right = s.length()-1;
        int left = 0;

        while(left <= right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left += 1;
            right -= 1;
        }

        return true;

    }
}
