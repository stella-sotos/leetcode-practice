class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ans = new ArrayList<>();
        for (int r = 0; r < numRows; r++) {
            ArrayList rowList = new ArrayList<Integer>();
            int cols = r + 1;

            for (int c = 0; c < cols; c++) {
                if (c == 0 || c == cols - 1) {
                    rowList.add(1);
                } else {
                    List<Integer> above = ans.get(r - 1);
                    int val = above.get(c - 1) + above.get(c);
                    rowList.add(val);
                }
            }

            ans.add(rowList);
        }
        return ans;

    }
}