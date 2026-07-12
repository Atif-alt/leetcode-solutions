class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];
        return solve(s, 0, set, memo);
    }

    public boolean solve(String s, int start, HashSet<String> set, Boolean[] memo) {

        if (start == s.length())
            return true;

        if (memo[start] != null)
            return memo[start];

        for (int end = start + 1; end <= s.length(); end++) {

            if (set.contains(s.substring(start, end))) {

                if (solve(s, end, set, memo))
                    return memo[start] = true;
            }
        }

        return memo[start] = false;
    }
}