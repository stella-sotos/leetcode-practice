class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int frontPtr = 0;
        int backPtr = height.length - 1;

        while (frontPtr < backPtr) {
            int curWater = (backPtr - frontPtr) * Math.min(height[backPtr], height[frontPtr]);
            if (curWater > maxWater) {
                maxWater = curWater;
            }
            if (height[backPtr] < height[frontPtr]) {
                backPtr--;
            } else {
                frontPtr++;
            }
        }

        return maxWater;

    }
}