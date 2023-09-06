package leetcode.topinterview150;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    public static void main(String[] args) {
        System.out.println(new WordSearchII().findWords(new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}}, new String[]{"oath", "pea", "eat", "rain"}));
    }

    // https://gist.github.com/SuryaPratapK/6329c354704632725dccc7ec5900d199
    // https://youtu.be/EmvsBM7o-5k?si=94aWFhQUUAAJSbvG
    public List<String> findWords(char[][] board, String[] words) {
        int r = board.length;
        int c = board[0].length;

        //Insert all words in TRIE
        for (int i = 0; i < words.length; ++i) {
            insert(words[i]);
        }

        // search words
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                solve(board, i, j, r, c, ans, root);
            }
        }
        return ans;
    }

    private void solve(char[][] board, int i, int j, int r, int c, List<String> ans, TrieNode current) {
        //Base case
        //If the trie doesn't have the current char OR cell is Visited
        int index = board[i][j] - 'a';
        if (board[i][j] == '$' || current.child[index] == null) {
            return;
        }
        current = current.child[index];
        if (current.endsHere > 0) {
            ans.add(current.word);
            current.endsHere -= 1;
        }

        char ch = board[i][j];   //Store current char
        board[i][j] = '$';  //Mark current node visited

        if (i > 0)     //TOP
            solve(board, i - 1, j, r, c, ans, current);
        if (i < r - 1)   //DOWN
            solve(board, i + 1, j, r, c, ans, current);
        if (j > 0)     //LEFT
            solve(board, i, j - 1, r, c, ans, current);
        if (j < c - 1)   //RIGHT
            solve(board, i, j + 1, r, c, ans, current);

        board[i][j] = ch;    //Mark current node as Unvisited by restoring the value

    }

    private class TrieNode {
        char val;
        String word;
        int endsHere;
        TrieNode[] child;

        TrieNode(char val) {
            this.val = val;
            this.word = "";
            this.endsHere = 0;
            this.child = new TrieNode[26];
        }
    }

    private TrieNode root = getNode('/');

    private TrieNode getNode(int index) {
        return new TrieNode((char) ('a' + index));
    }

    private void insert(String word) {
        TrieNode current = root;
        int index;
        for (int i = 0; i < word.length(); i++) {
            index = word.charAt(i) - 'a';
            if (current.child[index] == null) {
                current.child[index] = getNode(index);
            }
            current = current.child[index];
        }
        current.endsHere += 1;
        current.word = word;
    }
}
