/*
** Given a positive integer, return its corresponding column title as appear in an Excel sheet.
*/
class Solution {
    public String convertToTitle(int n) {
        if(n==0)return "";
        if(n>26){
            if(n%26==0) return convertToTitle(n/26 -1) + map(n%26);
            else return convertToTitle(n/26) + map(n%26);
        }
        else return map(n);
    }
    public String map(int n){
        if(n == 1)return "A";
        if(n == 2)return "B";
        if(n == 3)return "C";
        if(n == 4)return "D";
        if(n == 5)return "E";
        if(n == 6)return "F";
        if(n == 7)return "G";
        if(n == 8)return "H";
        if(n == 9)return "I";
        if(n == 10)return "J";
        if(n == 11)return "K";
        if(n == 12)return "L";
        if(n == 13)return "M";
        if(n == 14)return "N";
        if(n == 15)return "O";
        if(n == 16)return "P";
        if(n == 17)return "Q";
        if(n == 18)return "R";
        if(n == 19)return "S";
        if(n == 20)return "T";
        if(n == 21)return "U";
        if(n == 22)return "V";
        if(n == 23)return "W";
        if(n == 24)return "X";
        if(n == 25)return "Y";
        else return "Z";
        
    }
}