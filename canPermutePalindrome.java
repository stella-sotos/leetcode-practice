class Solution {
    public boolean canPermutePalindrome(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        boolean used = (chars.length%2 ==0);
        char last = '-';
        for(int i = 0; i<chars.length; i++){
            char c = chars[i];
            if(last == '-') last = c;
            else {
                if(c == last) last = '-'; 
                else if(used) return false;
                else if(!used) {
                    used = true;
                    last = c;
                }
            }
        }
        return last == '-' || !used;
    }
}