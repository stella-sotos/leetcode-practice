class Solution {
    public boolean isSubsequence(String s, String t) {
        int sPtr = 0, tPtr = 0;

        while (sPtr < s.length() && tPtr < t.length()) {
            char sc = s.charAt(sPtr);
            char tc = t.charAt(tPtr);
            if (sc == tc) {
                sPtr++;
                tPtr++;
            } else {
                tPtr++;
            }
        }
        return sPtr == s.length();
    }
}