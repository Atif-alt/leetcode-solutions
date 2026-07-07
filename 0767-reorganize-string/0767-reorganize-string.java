class Solution {
    public String reorganizeString(String s) {

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int max = 0;
        int letter = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] > max) {
                max = freq[i];
                letter = i;
            }
        }

        if (max > (s.length() + 1) / 2) {
            return "";
        }

        char[] ans = new char[s.length()];
        int index = 0;

        while (freq[letter] > 0) {
            ans[index] = (char)(letter + 'a');
            index += 2;
            freq[letter]--;
        }

        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {

                if (index >= s.length()) {
                    index = 1;
                }

                ans[index] = (char)(i + 'a');
                index += 2;
                freq[i]--;
            }
        }

        return new String(ans);
    }
}