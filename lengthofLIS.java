class Solution {
    public int lengthOfLIS(int[] nums) {
        return helper(nums, 0, 0, -1);
    }
    public int helper(int [] nums, int curLen, int i, int last){
        if(i>=nums.length) return curLen;
        if(last == -1){ //starting: use this value or skip it
            return Math.max(helper(nums, 0, i+1, -1), helper(nums, 1, i+1, i));
        }
        else if(nums[i]==nums[last]+1) //directly above always take this value
            return helper(nums, curLen + 1, i+1, i);
        else if(nums[i]>nums[last]){  //either continue this sequence or skip the val
            return Math.max(helper(nums, curLen + 1, i+1, i), helper(nums, curLen, i+1, last));
        }
        else if (nums[i]==nums[last]-1 || nums[i]==nums[last]){
            //if the value is the same or directly below just use last value;
            return curLen;
        }
        else //otherwise skip this value or start a new sequence
            return Math.max(helper(nums, curLen, i+1, last), helper(nums, 1, i+1, i));
    }
}