/*
** Given a non-empty array of non-negative integers nums, the degree of this array 
** is defined as the maximum frequency of any one of its elements.
** Your task is to find the smallest possible length of a (contiguous) subarray of nums, 
** that has the same degree as nums.
*/
class Solution {
    public int findShortestSubArray(int[] nums) {
        if(nums.length<=1) return nums.length;
        HashMap<Integer, Integer> h = new HashMap<>();
        int max = 0;
        ArrayList<Integer> maxVals = new ArrayList<>();
        for(int i = 0; i<nums.length; i++){
            int count = 0;
            if(h.containsKey(nums[i])) count = h.get(nums[i]);
            count = count+1;
            if(count>max) {
                max = count;
                maxVals.clear();
                maxVals.add(nums[i]);
            }
            else if(count==max) maxVals.add(nums[i]);
            h.put(nums[i],count);
        }
        int minRange = Integer.MAX_VALUE;
        for(int i : maxVals){
            int range = findRange(i, nums); 
            if(range<minRange) minRange = range;
        }
        return minRange;
    }
    public int findRange(int i, int[] nums){
        int b = 0;
        int e = 0;
        while(nums[b]!=i || nums[nums.length-1-e]!=i){
            if(nums[b]!=i)b++;
            if(nums[nums.length-1-e]!=i)e++;
        }
        return nums.length-e-b;
    }
}