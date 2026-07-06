class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] count = new int[26];

        // Count frequency of each task
        for (char task : tasks) {
            count[task - 'A']++;
        }

        // Find maximum frequency
        int maxFreq = 0;
        for (int i = 0; i < 26; i++) {
            maxFreq = Math.max(maxFreq, count[i]);
        }

        // Count how many tasks have maximum frequency
        int maxCount = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] == maxFreq) {
                maxCount++;
            }
        }

        int intervals = (maxFreq - 1) * (n + 1) + maxCount;

        return Math.max(intervals, tasks.length);
    }
}