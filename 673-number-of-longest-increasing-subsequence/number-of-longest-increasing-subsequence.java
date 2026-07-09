class Solution {
    public int findNumberOfLIS(int[] n) {

        int len = n.length;
        if (len == 0) return 0;

        int[] dp = new int[len];
        int[] count = new int[len];

        int max = 1;

        for (int i = 0; i < len; i++) {

            dp[i] = 1;
            count[i] = 1;

            for (int j = 0; j < i; j++) {

                if (n[j] < n[i]) {

                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }
                    else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }
            }

            max = Math.max(max, dp[i]);
        }

        int ans = 0;

        for (int i = 0; i < len; i++) {
            if (dp[i] == max) {
                ans += count[i];
            }
        }

        return ans;
    }
}