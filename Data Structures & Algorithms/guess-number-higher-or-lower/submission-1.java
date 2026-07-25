/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        
        while (left <= right) {
            // Prevents integer overflow when left and right are large
            int mid = left + (right - left) / 2; 
            
            int result = guess(mid);
            
            if (result == 0) {
                return mid; // Found the picked number
            } else if (result == -1) {
                right = mid - 1; // Guess was too high, narrow to left half
            } else {
                left = mid + 1;  // Guess was too low, narrow to right half
            }
        }
        
        return -1; // Fallback, though a match is guaranteed by constraints
    }
}