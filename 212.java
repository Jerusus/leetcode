import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    // public static void main(String[] args) {
    //     Solution212 s = new Solution212();
    //     char[][] mat = new char[][] {
    //         {'o', 'a', 'a', 'n'},
    //         {'e', 't', 'a', 'e'},
    //         {'i', 'h', 'k', 'r'},
    //         {'i', 'f', 'l', 'v'},
    //     };
    //     List<String> ss = s.findWords(mat, new String[]{"oath", "pea", "eat", "rain"});
    //     System.out.println(ss);
    // }

    Set<String> result = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie(words);

        int rows = board.length;
        int cols = board[0].length;
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                boolean[][] visited = new boolean[rows][cols];
                recurse(board, visited, x, y, trie.head);        
            }
        }
        return new ArrayList<String>(result);
    }

    public void recurse(char[][] board, boolean[][] visited, int x, int y, Node node) {
        if (x >= board.length || x < 0 || y >= board[0].length || y < 0) return;
        if (visited[x][y]) return;
        char c = board[x][y];
        if (!node.map.containsKey(c)) return;
        Node next = node.map.get(c);
        if (next.map.containsKey(' ')) {
            result.add(next.map.get(' ').word);
        }
        visited[x][y] = true;
        recurse(board, visited, x+1, y, next);
        recurse(board, visited, x, y+1, next);
        recurse(board, visited, x-1, y, next);
        recurse(board, visited, x, y-1, next);
        visited[x][y] = false;
    }

    class Trie {
        Node head;

        Trie(String[] words) {
            head = new Node(' ');
            for (String word : words) {
                Node pointer = head;
                for (char c : word.toCharArray()) {
                    if (pointer.map.containsKey(c)) {
                        pointer = pointer.map.get(c);
                    } else {
                        Node newNode = new Node(c);
                        pointer.map.put(c, newNode);
                        pointer = newNode;
                    }
                }
                // mark end of word
                Node end = new Node(' ');
                end.word = word;
                pointer.map.put(' ', end);
            }
        }

        boolean isWord(String word) {
            Node pointer = head;
            for (char c : word.toCharArray()) {
                if (pointer.map.containsKey(c)) {
                    pointer = pointer.map.get(c);
                } else {
                    return false;
                }
            }
            return pointer.map.containsKey(' ');
        }
    }

    class Node {
        char val;
        Map<Character, Node> map;
        String word;
        Node(char val) {
            this.val = val;
            this.map = new HashMap<>();
            this.word = null;
        }
    }
}