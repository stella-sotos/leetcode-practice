class Solution {
    public int pivotIndex(int[] nums) {
        // first calc total sum
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }

        // then check each index 1 by 1
        int lsum = 0;
        int rsum = sum - nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                lsum += nums[i - 1];
                rsum -= nums[i];
            }
            if (lsum == rsum) {
                return i;
            }
        }
        return -1;
    }
}