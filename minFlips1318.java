class Solution {
    public int minFlips(int a, int b, int c) {
        int maxVal = Math.max(Math.max(a, b), c);
        int ct = 0;
        int place = 0;
        int mask = 1 << place;
        int div = 1;
        while (mask <= maxVal) {
            // check if digit works
            int am = a & mask;
            int bm = b & mask;
            int cm = c & mask;
            // System.out.println("Mask: " + mask + " am: " + am + " bm: " + bm + " cm: " + cm);

            int diff;
            // only case where we need to flip 2 is if cm is 0 and neither am nor bm is 0
            if ((am | bm) != cm) {
                if (cm == 0 && (bm != 0 && am != 0)) {
                    ct += 2;
                } else {
                    ct++;
                }
            }
            place++;
            div = div * 2;
            mask = 1 << place;
        }
        return ct;
    }
}