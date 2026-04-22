class Solution {

    // Note: could optimize time by iterating over 26 char of alphabet instead of iterating over string.
    // could optimize space with array of size 26 instead of hashmaps.
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        // op1 == same set chars
        // op2 == same proportion of chars
        HashMap<Character, Integer> chars1 = new HashMap<>();
        HashMap<Character, Integer> chars2 = new HashMap<>();

        for (int i = 0; i < word1.length(); i++) {
            char c1 = word1.charAt(i);
            if (chars1.containsKey(c1)) {
                int ct = chars1.get(c1);
                chars1.put(c1, ct + 1);
            } else {
                chars1.put(c1, 1);
            }
            char c2 = word2.charAt(i);
            if (chars2.containsKey(c2)) {
                int ct = chars2.get(c2);
                chars2.put(c2, ct + 1);
            } else {
                chars2.put(c2, 1);
            }

        }

        if (!chars1.keySet().equals(chars2.keySet())) {
            return false;
        }
        List<Integer> v1 = new ArrayList<>(chars1.values());
        List<Integer> v2 = new ArrayList<>(chars2.values());
        
        Collections.sort(v1);
        Collections.sort(v2);

        if (v1.equals(v2)) {
            return true;
        }
        return false;
    }

}