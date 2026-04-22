class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        StringBuilder curWord = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ' && curWord.length() != 0) {
                addWord(ans, curWord);

            } else if (c != ' ') {
                curWord.append(c);
            }

        }
        addWord(ans, curWord);
        return ans.toString();
    }

    public void addWord(StringBuilder ans, StringBuilder curWord) {
        if (curWord.length() != 0) {
            if (ans.length() != 0) {
                ans.insert(0, ' ');
            }
            ans.insert(0, curWord);

            curWord.setLength(0);
        }
    }
}