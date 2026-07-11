class Solution {

    public void helper(int start, int[] cookies, int[] temp, int k) {
        if (start == cookies.length) {
            int maxi = Integer.MIN_VALUE;

            for (int i = 0; i < k; i++) {
                maxi = Math.max(maxi, temp[i]);
            }

            ans = Math.min(ans, maxi);
            return;
        }

        for (int i = 0; i < k; i++) {
            temp[i] += cookies[start];     // Take
            helper(start + 1, cookies, temp, k);
            temp[i] -= cookies[start];     // Backtrack
        }
    }

    int ans = Integer.MAX_VALUE;

    public int distributeCookies(int[] cookies, int k) {
        int[] temp = new int[k];
        helper(0, cookies, temp, k);
        return ans;
    }
}