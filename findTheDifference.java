/*
** Given two strings s and t which consist of only lowercase letters.
** String t is generated by random shuffling string s and then add one more letter at a random position.
** Find the letter that was added in t.
*/
class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            int count = 0;
            if(hm.containsKey(c)) count = hm.get(c);
            hm.put(c, count+1);
        }
        for(int j = 0; j<t.length();j++){
            char c = t.charAt(j);
            if(!hm.containsKey(c)) return c;
            else{
                int count = hm.get(c) -1;
                if(count ==0)hm.remove(c);
                else hm.put(c, count);
            }
        }
        return '.';
    }
}