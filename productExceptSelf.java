class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int zeroLoc = -1;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]==0&&zeroLoc ==-1)zeroLoc = i;
            else if(nums[i]==0) prod = 0;
            else prod = prod * nums[i];
        }
        for(int i = 0; i<nums.length; i++){
            if(i==zeroLoc)nums[i]=prod;
            else if(zeroLoc!=-1) nums[i]=0;
            else nums[i]= prod/nums[i];
        }
        return nums;
    }
}