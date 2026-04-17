class Solution {
    HashMap<Integer, Integer> cache;

    public int tribonacci(int n) {
        int tri = 0;
        int last3 = 0, last2 = 0, last1 = 0;
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                tri = 0;
            } else if (i <= 2) {
                last3 = last2;
                last2 = last1;
                last1 = tri;
                tri = 1;
            } else {
                last3 = last2;
                last2 = last1;
                last1 = tri;
                tri = last3 + last2 + last1;
            }
        }
        return tri;
    }
}