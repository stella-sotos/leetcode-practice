//Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        return checkInChunks(s1,s2);
    }
    public boolean checkInChunks(String s, String target){
        if(s.length()>target.length()) return false;
        char []goal = s.toCharArray(); 
        Arrays.sort(goal); 
        for(int i = 0; i<=target.length()-s.length();i++){
            String chunk = target.substring(i, i+s.length());
            char []arr = chunk.toCharArray(); 
            Arrays.sort(arr); 
            boolean ans = true;
            for(int j = 0; j<arr.length; j++){
                if(goal[j]!=arr[j]) ans = false;
            }
            if(ans) return true;
        }
        return false;
    }
}