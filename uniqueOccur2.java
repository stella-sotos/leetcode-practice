class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> valCounts = new HashMap<>(); // map val -> count
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            int newCt = 0;
            if (valCounts.containsKey(val)) {
                int prevCt = valCounts.get(val);
                newCt = prevCt + 1;
            } else {
                newCt = 1;
            }
            valCounts.put(val, newCt);
        }
        // now check for uniqueness
        HashSet<Integer> occ = new HashSet<>(); // keep track of occurances and uniqueness
        for (Map.Entry<Integer, Integer> entry : valCounts.entrySet()) {
            if (!occ.add(entry.getValue())) {
                return false;
            }
        }
        return true;

    }
}