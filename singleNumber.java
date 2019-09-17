class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        ArrayList<Integer> possibleAns = new ArrayList<>();
        for(int i = 0; i<nums.length; i++){
            if(hm.containsKey(nums[i])) {
                hm.put(nums[i], hm.get(nums[i])+1);
                if(possibleAns.contains(nums[i])) possibleAns.remove((Object)nums[i]);
            }
            else{
                hm.put(nums[i],1);
                possibleAns.add(nums[i]);
            }
        }
        return possibleAns.get(0);
        
    }
}