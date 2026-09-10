class Solution {
    public int longestConsecutive(int[] nums) {
        int longestStreak = 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        for(int num : set){
            if(!set.contains(num-1)){
                int currentStreak = 1;
                int currentNum = num;

                while(set.contains(currentNum + 1)){
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
