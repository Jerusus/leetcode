import java.util.Arrays;

class Solution {
  public boolean exist(char[][] board, String word) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == word.charAt(0)) {
          char[][] copy = Arrays.stream(board).map(char[]::clone).toArray(char[][]::new);
          copy[i][j] = '0';
          boolean found = search(copy, word, i, j, 1);
          if (found) {
            return true;
          }
        }
      }
    }

    return false;
  }

  public boolean search(char[][] board, String word, int m, int n, int index) {
    if (index >= word.length()) {
      return true;
    }
    boolean res = false;
    char lookingFor = word.charAt(index);
    int i = m + 1;
    int j = n;
    if (inBounds(board, i, j) && board[i][j] == lookingFor) {
      char[][] copy = Arrays.stream(board).map(char[]::clone).toArray(char[][]::new);
      copy[i][j] = '0';
      res = res || search(copy, word, i, j, index + 1);
    }
    i = m - 1;
    j = n;
    if (inBounds(board, i, j) && board[i][j] == lookingFor) {
      char[][] copy = Arrays.stream(board).map(char[]::clone).toArray(char[][]::new);
      copy[i][j] = '0';
      res = res || search(copy, word, i, j, index + 1);
    }
    i = m;
    j = n + 1;
    if (inBounds(board, i, j) && board[i][j] == lookingFor) {
      char[][] copy = Arrays.stream(board).map(char[]::clone).toArray(char[][]::new);
      copy[i][j] = '0';
      res = res || search(copy, word, i, j, index + 1);
    }
    i = m;
    j = n - 1;
    if (inBounds(board, i, j) && board[i][j] == lookingFor) {
      char[][] copy = Arrays.stream(board).map(char[]::clone).toArray(char[][]::new);
      copy[i][j] = '0';
      res = res || search(copy, word, i, j, index + 1);
    }
    return res;
  }

  public boolean inBounds(char[][] board, int i, int j) {
    return !(i < 0 || i >= board.length || j < 0 || j >= board[0].length);
  }
}