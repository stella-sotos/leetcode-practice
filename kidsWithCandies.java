class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
     int max = 0-Integer.MIN_VALUE; 
     // find original max
     for(int i = 0; i< candies.length;i++){
        if(candies[i]> max){
            max = candies[i];
        }
     }  
     List<Boolean> ans = new ArrayList<>(candies.length);
     for(int i = 0; i< candies.length; i++){
        if(candies[i] + extraCandies >= max){
            ans.add(i, true);
        }
        else{
            ans.add(i, false);
        }
     }
         return ans;

    }
}