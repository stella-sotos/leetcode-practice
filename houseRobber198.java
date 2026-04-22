class Solution {
    int[] dp; // max amoutn you can rob starting from index i

    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        else if (nums.length == 1)
            return nums[0];
        else if (nums.length == 2) { // pick max of indices
            return Math.max(nums[0], nums[1]);
        } else {
            dp = new int[nums.length];
            dp[nums.length - 1] = nums[nums.length - 1];
            dp[nums.length - 2] = Math.max(nums[nums.length - 1], nums[nums.length - 2]);
            for (int i = nums.length - 3; i >= 0; i--) {
                dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
            }
            return dp[0];
        }
    }
}