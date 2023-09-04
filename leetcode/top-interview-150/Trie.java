package leetcode.topinterview150;

public class Trie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));    // return True
    }

    private class TrieNode {
        char val;
        int count;
        int endsHere;
        TrieNode[] child;

        TrieNode(char val) {
            this.val = val;
            this.count = 0;
            this.endsHere = 0;
            this.child = new TrieNode[26];
        }
    }

    private TrieNode root;

    private TrieNode getNode(int index) {
        return new TrieNode((char) ('a' + index));
    }

    public Trie() {
        root = getNode('/');
    }

    public void insert(String word) {
        TrieNode current = root;
        int index;
        for (int i = 0; i < word.length(); i++) {
            index = word.charAt(i) - 'a';
            if (current.child[index] == null) {
                current.child[index] = getNode(index);
            }
            current.child[index].count += 1;
            current = current.child[index];
        }
        current.endsHere += 1;
    }

    public boolean search(String word) {
        TrieNode current = root;
        int index;
        for (int i = 0; i < word.length(); i++) {
            index = word.charAt(i) - 'a';
            if (current.child[index] == null) {
                return false;
            }
            current = current.child[index];
        }
        return current.endsHere > 0;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        int index;
        for (int i = 0; i < prefix.length(); ++i) {
            index = prefix.charAt(i) - 'a';
            if (current.child[index] == null)
                return false;
            current = current.child[index];
        }
        return (current.count > 0);
    }
}
