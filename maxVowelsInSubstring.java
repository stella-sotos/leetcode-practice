class Solution {
    public int maxVowels(String s, int k) {
        int max = 0;
        int prevCt = 0;

        // iterate over possible starting indeces
        for (int i = 0; i <= (s.length() - k); i++) {
            int ct = 0;
            // if we are just starting we need to check each char
            if (i == 0) {
                for (int j = 0; j < k; j++) {
                    String c = s.substring(j, j + 1);
                    if (isVowel(c)) {
                        ct++;
                    }
                }
            } else {
                // otherwise just check the two at the ends
                String lastChar = s.substring(i - 1, i);
                String newChar = s.substring(i + k -1, i + k );
                int lastCharCt = isVowel(lastChar) ? 1 : 0;
                int newCharCt = isVowel(newChar) ? 1 : 0;
                ct = prevCt - lastCharCt + newCharCt;
            }

            if (ct > max) {
                max = ct;
                if (max == k) {
                    return max;
                }
            }
            prevCt = ct;
        }

        return max;

    }

    public boolean isVowel(String s) {
        String vowels = "aeiou";
        return vowels.contains(s);
    }
}