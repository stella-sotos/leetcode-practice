class Solution {
    public int removeDuplicates(int[] nums) {
        int dupsFound = 0;
        int last = 0;
        for (int i = 0; i < (nums.length); i++) {
            if (i != 0 && nums[i] == last) {
                dupsFound++;
            }
            last = nums[i];
            if (i - dupsFound > 0) {
                nums[i - dupsFound] = nums[i];
            }

        }
        return nums.length - dupsFound;
    }
}