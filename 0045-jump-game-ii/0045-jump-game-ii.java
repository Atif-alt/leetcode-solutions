class Solution {
    public int jump(int[] n) {

        if (n.length == 1) {
            return 0;
        }

        int sum = 0;
        int farthest = 0;
        int end = 0;

        for (int i = 0; i < n.length - 1; i++) {

            farthest = Math.max(farthest, i + n[i]);

            if (i == end) {
                sum++;
                end = farthest;
            }
        }

        return sum;
    }
}