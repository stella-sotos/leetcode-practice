class TrieNode {
    char c;
    LinkedList<TrieNode> children; // Faster with an Array of size 26 for O(1) char lookups

    public void print() {
        System.out.print(this.c + " ");
        for (TrieNode node : this.children) {
            node.print();
        }
    }

    public TrieNode(char c) {
        this.c = c;
        this.children = new LinkedList<TrieNode>();
    }

}

class Trie {
    TrieNode tn;

    public Trie() {
        tn = new TrieNode(' ');
    }

    public void insert(String word) {
        TrieNode t = this.tn;
        LinkedList<TrieNode> kids = t.children;

        for (int i = 0; i <= word.length(); i++) {
            char b = i == word.length() ? '*' : word.charAt(i);
            boolean found = false;
            for (int j = 0; j < kids.size(); j++) {
                TrieNode k = kids.get(j);
                if (k.c == b) {
                    t = k;
                    found = true;
                    kids = t.children;
                    break;
                }
            }
            if (!found) {
                t = new TrieNode(b);
                kids.add(t);
                kids = t.children;

            }
        }
    }

    public boolean search(String word) {

        return startsWith(word + '*');
    }

    public boolean startsWith(String prefix) {
        TrieNode t = this.tn;
        LinkedList<TrieNode> kids = t.children;

        for (int i = 0; i < prefix.length(); i++) {
            char b = prefix.charAt(i);
            boolean found = false;

            for (int j = 0; j < kids.size(); j++) {
                TrieNode k = kids.get(j);

                if (k.c == b) {
                    t = k;
                    found = true;
                    kids = t.children;
                    break;
                }
            }
            if (!found) {
                return false;

            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */