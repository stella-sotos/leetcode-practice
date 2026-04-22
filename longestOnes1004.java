class Solution {
    public int longestOnes(int[] nums, int k) {
        if (nums.length <= k)
            return nums.length;

        // find first setion with k used up
        int zCount = 0;
        int start = 0;
        int end = 0;
        int maxLength = k;
        while (start >= 0 && start < nums.length && end < nums.length) {
            int newDig = nums[end];
            if (zCount == k && newDig == 0) { // already at max zeros, found new end
                int length = end - start;
                System.out.println("new length: " + length + " maxLength: " + maxLength);
                if (length > maxLength) {
                    maxLength = length;
                }
                // next step is to iterate start, decr zCount if needed
                if (nums[start] == 0)
                    zCount--;
                start++;
            } else {
                if (newDig == 0) {
                    zCount++;
                }
                end++;
            }
        }
        int length = end - start;
        System.out.println("new length: " + length + " maxLength: " + maxLength);

        if (length > maxLength) {
            maxLength = length;
        }
        return maxLength;
    }

    public int solOne(int[] nums, int k) {
        int maxLength = k;
        for (int i = 0; i < nums.length; i++) {
            int zcount = 0;
            int length = 1;
            if (nums[i] == 0)
                zcount++;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == 0) {
                    zcount++;
                    length++;
                    if (zcount > k) {
                        length--;
                        j = nums.length;
                    }
                } else {
                    length++;
                }
            }
            if (length > maxLength) {
                maxLength = length;
            }
        }
        return maxLength;

    }
}