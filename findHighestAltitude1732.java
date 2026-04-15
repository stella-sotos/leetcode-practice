class Solution {
    public int largestAltitude(int[] gain) {
        int highestPt = 0;
        int currentPt = 0;
        for(int i = 0; i< gain.length; i++){
            currentPt +=gain[i];
            if(currentPt > highestPt){
                highestPt = currentPt;
            }
        }
        return highestPt;
    }
}