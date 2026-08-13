class WordDictionary {

    private static class TrieNode {
        private final TrieNode[] children = new TrieNode[26];
        private boolean isEndOfWord = false;
    }

    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        return searchInNode(word, 0, root);
    }

    private boolean searchInNode(String word, int index, TrieNode node) {
        if (node == null) {
            return false;
        }

        // Base case: Reached the end of the word string
        if (index == word.length()) {
            return node.isEndOfWord;
        }

        char ch = word.charAt(index);

        if (ch == '.') {
            // Wildcard: Check all 26 possible children
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null && searchInNode(word, index + 1, node.children[i])) {
                    return true;
                }
            }
            return false;
        } else {
            // Standard letter match
            int childIndex = ch - 'a';
            return searchInNode(word, index + 1, node.children[childIndex]);
        }
    }
}