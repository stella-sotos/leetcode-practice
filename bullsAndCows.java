class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        String secretCowCheck ="";
        String guessCowCheck ="";
        for(int i = 0; i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i))bulls++;
            else {
                secretCowCheck+=secret.charAt(i);
                guessCowCheck+=guess.charAt(i);
            }
        }
        for(int i = 0;i<guessCowCheck.length();i++){
            if(secretCowCheck.contains(guessCowCheck.charAt(i)+"")){
                cows++;
                int index = secretCowCheck.indexOf(guessCowCheck.charAt(i));
                secretCowCheck = secretCowCheck.substring(0,index)+secretCowCheck.substring(index+1);
            }
        }
        return bulls+"A"+cows+"B";
    }
}