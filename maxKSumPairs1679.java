class Solution {
    public int maxOperations(int[] nums, int k) {

        Arrays.sort(nums);
        return maxOp(nums, k, 0, nums.length - 1);

    }

    public int maxOp(int[] nums, int k, int start, int end) {
        if (start >= end)
            return 0;

        int sum = nums[start] + nums[end];

        if (sum == k) {
            return 1 + maxOp(nums, k, start + 1, end - 1);
        }

        else if (sum > k) {
            return maxOp(nums, k, start, end - 1);
        } else
            return maxOp(nums, k, start + 1, end);

    }

}