class Solution {
    public int lengthOfLIS(int[] n) {
        int[] dp = new int[n.length];

        for (int i = 0; i < n.length; i++) {
            dp[i] = 1;
        }

        int ans = 1;

        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < i; j++) {
                if (n[i] > n[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}