/*
** Given an array of n integers nums and a target, find the number of index triplets i, j, k 
** with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
*/
class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums.length<3) return 0;
        int count = 0;
        for(int i = 0; i<nums.length-2;i++){
           count = count + sumLeft(nums, i+1, target, nums[i], 2);
        } 
        return count;
    }
    public int sumLeft(int []nums, int startIndex, int target, int sum, int addsLeft){
        if(addsLeft==0 && sum<target) return 1;
        else if(addsLeft<=0||startIndex+addsLeft>nums.length) return 0;
        int count = 0;
        for(int i = startIndex; i<nums.length-addsLeft+1;i++){
            count = count+ sumLeft(nums, i+1, target,sum+nums[i],addsLeft-1);
        }
        return count;
        
    }
}