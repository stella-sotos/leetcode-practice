class Solution {
    public int hIndex(int[] citations) {
        int h = 0;
        for(int i = 0; i< citations.length;i++){
            for(int val =h; val<= citations[i]; val++){
                if(val<=citations.length-i) h = val;
                else return h;
            }
        }
            
        return h;
    }
}