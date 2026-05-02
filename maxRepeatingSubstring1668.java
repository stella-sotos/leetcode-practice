class Solution {
    public int maxRepeating(String sequence, String word) {
        int index = sequence.indexOf(word);
        if (index == -1)
            return 0;
        else if (sequence.length() == word.length())
            return 1;
        else {
            int[] dp = new int[sequence.length()];
            int max = 0;
            for (int i = (sequence.length() - word.length()); i >= 0; i--) {
                index = sequence.indexOf(word, i);
                if (index != -1 && index == i) {
                    dp[i] = 1 + (i + word.length() < sequence.length() ? dp[i + word.length()] : 0);
                    if (dp[i] > max)
                        max = dp[i];
                }
            }

            return max;
        }
    }
}