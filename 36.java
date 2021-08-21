import java.util.HashSet;
import java.util.Set;

class Solution {
  public boolean isValidSudoku(char[][] board) {
    for (int i = 0; i < 9; i++) {
      Set<Character> s = new HashSet<>();
      Set<Character> t = new HashSet<>();
      for (int j = 0; j < 9; j++) {
        Character c = board[i][j];
        if (c == '.')
          i = i;
        else if (s.contains(c))
          return false;
        else
          s.add(c);
        Character d = board[j][i];
        if (d == '.')
          continue;
        if (t.contains(d))
          return false;
        t.add(d);
      }
    }

    for (int i = 0; i < 9; i += 3) {
      for (int j = 0; j < 9; j += 3) {
        Set<Character> s = new HashSet<>();
        for (int k = 0; k < 3; k++) {
          for (int l = 0; l < 3; l++) {
            Character c = board[i + k][j + l];
            if (c == '.')
              continue;
            if (s.contains(c))
              return false;
            s.add(c);
          }
        }
      }
    }

    return true;
  }
}