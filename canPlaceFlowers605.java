class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0)
            return true;
        int spotsFound = 0;
        boolean lastFlower = false;
        for (int i = 0; i < flowerbed.length; i++) {
            boolean isFlower = flowerbed[i] == 1;
            boolean nextFlower = i < flowerbed.length - 1 ? flowerbed[i + 1] == 1 : false;
            if (!lastFlower && !isFlower && !nextFlower) {
                spotsFound++;
                lastFlower = true;
                if (spotsFound == n)
                    return true;
            } else {
                lastFlower = isFlower;
            }
        }
        return spotsFound == n;

    }
}