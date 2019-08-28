//Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length ==0) return "";
        int pt = 0;
        String ans = "";
        int max = Integer.MAX_VALUE;
        while(pt<max){
            if(strs[0].length()==0) return ans;
            char c= strs[0].charAt(pt);
            boolean inAll = true;
            for(int i = 0; i<strs.length;i++){
                if(strs[i].length()<max) max = strs[i].length();
                if(pt>=max)return ans;
                if(strs[i].charAt(pt)!=c) inAll=false;
            }
            if(inAll){
                ans+=c;
                pt++;
            }
            else{
                return ans;
            }
        }
        
        return ans;
    }
}