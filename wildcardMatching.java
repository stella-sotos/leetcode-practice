/*
** Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
** '?' Matches any single character.
** '*' Matches any sequence of characters (including the empty sequence).
** The matching should cover the entire input string (not partial).
*/

class Solution {
    public boolean isMatch(String s, String p) {
        if((s.length()>=1&&p.length()>=1) && ( s.charAt(s.length()-1)!=p.charAt(p.length()-1) &&
           p.charAt(p.length()-1)!='?'&&p.charAt(p.length()-1)!='*')) return false;
        if((p.length()>=1 && onlyStars(p)) ||
          (s.length()==0&&p.length()==0)) return true;
        else if(s.length()==0||(p.length()==0&&p!="*"&&p!="?")) return false;
        else if(s.charAt(0)==p.charAt(0) || p.charAt(0)=='?') return isMatch(s.substring(1),p.substring(1));
        else if(p.charAt(0)=='*'){
            for(int i = 0; i<s.length();i++){
                if(isMatch(s.substring(i),p.substring(1))) return true;
            }
        }
        return false;
    }
    public boolean onlyStars(String p){
        for(int i = 0; i<p.length();i++){
            if(p.charAt(i)!='*') return false;
        }
        return true;
    }
}