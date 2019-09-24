class Solution {
    public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        int last = Integer.MIN_VALUE;
        int[]ans = new int[2];
        int index = 0;
        for(int i = 0; i<nums.length;i++){
            if(last == Integer.MIN_VALUE) last = nums[i];
            else if(last != nums[i]){
                ans[index]= last;
                index++;
                last = nums[i];
            }
            else last = Integer.MIN_VALUE;
        }
        if(index == 1) ans[index] = nums[nums.length-1];
        return ans;
    }
}