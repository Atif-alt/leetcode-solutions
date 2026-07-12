import java.util.Arrays;

class Solution {

    public boolean makesquare(int[] matchsticks) {

        int sum = 0;

        for (int i = 0; i < matchsticks.length; i++) {
            sum += matchsticks[i];
        }

        if (sum % 4 != 0) {
            return false;
        }

        int side = sum / 4;

        Arrays.sort(matchsticks);

        // Reverse the array (Descending Order)
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }

        int[] sides = new int[4];

        return solve(matchsticks, sides, side, 0);
    }

    public boolean solve(int[] matchsticks, int[] sides, int side, int index) {

        // Base Case
        if (index == matchsticks.length) {
            return sides[0] == side &&
                   sides[1] == side &&
                   sides[2] == side &&
                   sides[3] == side;
        }

        // Try placing the current matchstick on each side
        for (int i = 0; i < 4; i++) {

            if (sides[i] + matchsticks[index] <= side) {

                // Choose
                sides[i] += matchsticks[index];

                // Explore
                if (solve(matchsticks, sides, side, index + 1)) {
                    return true;
                }

                // Backtrack
                sides[i] -= matchsticks[index];
            }
        }

        return false;
    }
}