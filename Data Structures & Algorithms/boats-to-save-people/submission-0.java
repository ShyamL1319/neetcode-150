class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // Sort to enable the two-pointer greedy approach
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        int boats = 0;
        
        while (left <= right) {
            // If the lightest and heaviest can fit together
            if (people[left] + people[right] <= limit) {
                left++; // Lightest person is handled
            }
            // Heaviest person is always handled in this turn
            right--; 
            boats++;
        }
        
        return boats;
    }
}