class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Step 1: Count frequencies of each task
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }

        // Step 2: Sort to find the max frequency
        Arrays.sort(freq);
        int fMax = freq[25];

        // Step 3: Calculate the number of tasks that have this same max frequency
        int nMax = 0;
        for (int f : freq) {
            if (f == fMax) {
                nMax++;
            }
        }

        // Step 4: Calculate minimum intervals using the formula
        // (fMax - 1) * (n + 1) covers the chunks and their cooling periods
        // nMax covers the final occurrences of the most frequent tasks
        int minIntervals = (fMax - 1) * (n + 1) + nMax;

        // Step 5: Return the larger of the formula result or the actual task count
        // (If we have more tasks than slots, we just fill the idles)
        return Math.max(minIntervals, tasks.length);
    }
}