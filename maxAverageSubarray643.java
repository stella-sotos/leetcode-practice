class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length;

        if (k == len) {
            return computeSum(nums, 0, k) / k;
        }

        double bestSum = computeSum(nums, 0, k);
        double sum = bestSum;
        for (int i = 0; i <= len - k; i++) {
            if (i > 0) {
                sum = sum + nums[k + i - 1] - nums[i - 1];
            }
            if (sum > bestSum) {
                bestSum = sum;
            }
        }

        return bestSum / k;
    }

    public double computeSum(int[] nums, int start, int k) {

        int sum = 0;
        for (int i = start; i < start + k; i++) {
            sum += nums[i];
        }
        return (double) sum;
    }
}