class Solution {
    public int maximum69Number(int num) {

        int temp = num;
        int pos = 1;
        int lastSix = -1;

        while (temp > 0) {
            if (temp % 10 == 6) {
                lastSix = pos;
            }
            temp /= 10;
            pos *= 10;
        }

        if (lastSix != -1) {
            num += 3 * lastSix;
        }

        return num;
    }
}