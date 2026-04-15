class Solution {
    public String mergeAlternately(String word1, String word2) {
     int len = Math.min(word1.length(), word2.length());
     String result = "";
     for (int i = 0; i< len; i++)   {
        result += word1.substring(i, i+1) + word2.substring(i, i+1);
     }
     if(len < word1.length()){
        result += word1.substring(len, word1.length());
     }
     else if(len < word2.length()){
        result += word2.substring(len, word2.length());
     }
     return result;
    }
}