class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        int ptr1 = 0;
        int ptr2 = s.length() - 1;
        while (ptr1 < ptr2) {
            char c1 = s.charAt(ptr1);
            char c2 = s.charAt(ptr2);
            System.out.println("c1: "+ c1+" c2: "+c2);

            if (isVowel(c1) && isVowel(c2)) {
                sb.setCharAt(ptr1, c2);
                sb.setCharAt(ptr2, c1);
                ptr1++;
                ptr2--;
            } else {
                if (!isVowel(c1)) {
                    ptr1++;
                }
                if (!isVowel(c2)) {
                    ptr2--;
                }
            }

        }
        return sb.toString();

    }

    public String reverseVowels1(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Character> vowels = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isVowel(c)) {
                vowels.push(c);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isVowel(c)) {
                char v = vowels.pop();
                sb.setCharAt(i, v);
            }
        }

        return sb.toString();

    }

    public boolean isVowel(char c) {
        return c == 'A' || c == 'a' ||
                c == 'E' || c == 'e' ||
                c == 'I' || c == 'i' ||
                c == 'O' || c == 'o' ||
                c == 'U' || c == 'u';
    }
}
