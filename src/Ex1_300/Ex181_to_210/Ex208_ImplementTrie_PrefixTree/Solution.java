package Ex1_300.Ex181_to_210.Ex208_ImplementTrie_PrefixTree;

/**
 * 问题重点在于, 内部存储一个TrieNode数组, 每次input的char, 都会 -'a' 这样,
 * 放到对应数组中, 这样找到数组应该会比hash更快
 */
public class Solution {

    class TrieNode {
        public boolean isWord;
        public TrieNode[] children = new TrieNode[26]; // a-z in lower case

        public TrieNode() {

        }
    }

    class Trie {
        private TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode traversing = root;
            for (char c : word.toCharArray()) {
                if (traversing.children[c - 'a'] == null)
                    traversing.children[c - 'a'] = new TrieNode();
                traversing = traversing.children[c - 'a'];
            }
            traversing.isWord = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode traversing = root;
            for (char c : word.toCharArray()) {
                if (traversing.children[c - 'a'] == null)
                    return false;
                traversing = traversing.children[c - 'a'];
            }
            return traversing.isWord;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            // we build Trie deep to ... layer, only when we meet a word that at least reach this ... layer
            // that means, if we can reach ... (prefix), we must have at least one word is start with this
            // prefix
            TrieNode traversing = root;
            for (char c : prefix.toCharArray()) {
                if (traversing.children[c - 'a'] == null)
                    return false;
                traversing = traversing.children[c - 'a'];
            }
            return true;
        }
    }

}
