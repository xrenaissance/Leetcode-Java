package com.inuker.solution;

/**
 * Created by dingjikerbo on 16/11/23.
 */

/**
 * https://leetcode.com/articles/implement-trie-prefix-tree/
 */
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        char[] s = word.toCharArray();
        TrieNode node = root;
        for (char c : s) {
            if (node.nexts[c - 'a'] == null) {
                node.nexts[c - 'a'] = new TrieNode();
            }
            node = node.nexts[c - 'a'];
        }
        node.word = word;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        char[] s = word.toCharArray();
        TrieNode node = root;
        for (char c : s) {
            if (node.nexts[c - 'a'] == null) {
                return false;
            } else {
                node = node.nexts[c - 'a'];
            }
        }
        return node.word != null;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        char[] s = prefix.toCharArray();
        TrieNode node = root;
        for (char c : s) {
            if (node.nexts[c - 'a'] == null) {
                return false;
            } else {
                node = node.nexts[c - 'a'];
            }
        }
        return true;
    }

    class TrieNode {

        TrieNode[] nexts = new TrieNode[26];
        String word;

        // Initialize your data structure here.
        public TrieNode() {

        }
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
