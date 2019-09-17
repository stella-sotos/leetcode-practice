class Solution {
    public boolean canJump(int[] nums) {
        return helper(nums, 0);
    }
    public boolean helper(int[] nums, int index) {
        if(index == nums.length -1) return true;
        if(index>=nums.length) return false;
        int start = Math.min(nums[index], nums.length-index);
        for(int i = start; i>=1;i--){
            if(helper(nums, index+i)) return true;
        }
        return false;
    }
}