package com.inuker.solution;

/**
 * Created by dingjikerbo on 2016/11/22.
 */

public class WordDictionary {

    private TrieNode mRoot = new TrieNode();

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = mRoot;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.nodes[c - 'a'] == null) {
                node.nodes[c - 'a'] = new TrieNode();
            }
            node = node.nodes[c - 'a'];
        }
        node.word = word;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(mRoot, word, 0);
    }

    private boolean search(TrieNode node, String word, int start) {
        if (start == word.length()) {
            return node != null && node.word != null;
        }
        if (node == null) {
            return false;
        }
        if (word.charAt(start) != '.') {
            return search(node.nodes[word.charAt(start) - 'a'], word, start + 1);
        }
        for (int i = 0; i < 26; i++) {
            if (search(node.nodes[i], word, start + 1)) {
                return true;
            }
        }
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");

