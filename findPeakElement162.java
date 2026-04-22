class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1)
            return 0;
        int start = 0;
        int end = nums.length;
        while (start < end) { 
            int ptr = (end - start) / 2 + start;
            // System.out.println("Start: " + start + " End: " + end + " Ptr: " + ptr);
            if ((ptr == 0 && nums[ptr] > nums[ptr + 1]) ||
                    (ptr == nums.length - 1 && nums[ptr] > nums[ptr - 1]) ||
                    (nums[ptr] > nums[ptr - 1] && nums[ptr] > nums[ptr + 1]))
                return ptr;
            else if (nums[ptr] < nums[ptr - 1]) {// indicates there's a peak to the left
                end = ptr;
            } else {
                start = ptr + 1;
            }
        }
        return start;
    }
}