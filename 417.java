import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    if (heights.length == 0) {
      return new ArrayList<>();
    }
    boolean[][] goes_into_pac = new boolean[heights.length][heights[0].length];
    boolean[][] goes_into_atl = new boolean[heights.length][heights[0].length];

    for (int i = 0; i < goes_into_pac.length; i++) {
      goes_into_pac[i][0] = true;
    }
    for (int i = 0; i < goes_into_pac[0].length; i++) {
      goes_into_pac[0][i] = true;
    }

  }
}