class Solution {

    int[] dp;

    public int minCut(String s) {
        int n = s.length();
        dp = new int[n];
        Arrays.fill(dp, -1);

        return helper(0, s) - 1;
    }

    public int helper(int start, String s) {
        if (start == s.length()) {
            return 0;
        }

        if (dp[start] != -1) {
            return dp[start];
        }

        int min = Integer.MAX_VALUE;

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                int partitions = 1 + helper(end + 1, s);
                min = Math.min(min, partitions);
            }
        }

        return dp[start] = min;
    }

    public boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}