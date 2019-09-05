/*
** You have a list of words and a pattern, and you want to know which words in words matches the pattern.
** A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.
** (Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)
** Return a list of the words in words that match the given pattern. 
** You may return the answer in any order.
*/
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for(String word : words){
            if(patternHolds(word,pattern))ans.add(word);
        }
        return ans;
    }
    public boolean patternHolds(String word, String pattern){
        HashMap<Character, Character> h = new HashMap<>();
        for(int i = 0; i<Math.min(pattern.length(),word.length());i++){
            char p = pattern.charAt(i);
            char w = word.charAt(i);
            if((h.containsKey(p)&&h.get(p)!=w)||(h.containsValue(w)&&!h.containsKey(p))) return false;
            else h.put(p,w);
        }
        return true;
    }
}