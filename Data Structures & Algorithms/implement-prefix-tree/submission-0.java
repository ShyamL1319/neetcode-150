public class PrefixTree {

    private static class TrieNode {
        private final TrieNode[] children = new TrieNode[26];
        private boolean isEndOfWord = false;
    }

    private final TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    /** Inserts a word into the prefix tree. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    /** Returns true if the word is in the prefix tree. */
    public boolean search(String word) {
        TrieNode node = findNode(word);
        return node != null && node.isEndOfWord;
    }

    /** Returns true if there is any word in the prefix tree that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return findNode(prefix) != null;
    }

    /** Helper method to traverse the tree for a given string sequence. */
    private TrieNode findNode(String str) {
        TrieNode node = root;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}
