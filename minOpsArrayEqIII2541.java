class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {

        if (k == 0) {
            return Arrays.equals(nums1, nums2) ? 0 : -1;
        }

        int n = nums1.length;

        long plusOps = 0;
        long minusOps = 0;

        for (int i = 0; i < n; i++) {
            if (nums1[i] + k <= nums2[i] &&
                    (nums2[i] - nums1[i]) % k == 0) {
                int mults = (nums2[i] - nums1[i]) / k;
                plusOps += mults;
                nums1[i] += k * mults;
            } else if (nums1[i] - k >= nums2[i]
                    && (nums1[i] - nums2[i]) % k == 0) {
                int mults = (nums1[i] - nums2[i]) / k;

                minusOps += mults;
                nums1[i] -= k * mults;
            }
            // at this point it's gotta be equal or theres no sol
            if (nums1[i] != nums2[i])
                return -1;

        }

        return (plusOps == minusOps) ? plusOps : -1;

    }
}