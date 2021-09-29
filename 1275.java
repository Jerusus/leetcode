class Solution {
  public String tictactoe(int[][] moves) {
    boolean[] x = new boolean[9];
    boolean[] o = new boolean[9];
    for (int i = 0; i < moves.length; i++) {
      if (i % 2 == 0) {
        int pos = moves[i][0] * 3 + moves[i][1];
        x[pos] = true;
        if (won(x)) {
          return "A";
        }
      } else {
        int pos = moves[i][0] * 3 + moves[i][1];
        o[pos] = true;
        if (won(o)) {
          return "B";
        }
      }
    }
    return moves.length == 9 ? "Draw" : "Pending";
  }

  boolean won(boolean[] b) {
    int[][] wins = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 }, { 0, 4, 8 },
        { 2, 4, 6 } };
    for (int[] win : wins) {
      if (b[win[0]] && b[win[1]] && b[win[2]]) {
        return true;
      }
    }
    return false;
  }
}