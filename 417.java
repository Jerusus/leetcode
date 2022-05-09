import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
  // Keeps track of cells we have already visited.
  boolean[][] visited_pac;
  boolean[][] visited_atl;

  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    visited_pac = new boolean[heights.length][heights[0].length];
    visited_atl = new boolean[heights.length][heights[0].length];

    // Do BFS from pacific ocean, then again from Atlantic ocean.
    Queue<int[]> q = new LinkedList<>();
    for (int i = 0; i < heights.length; i++) {
      q.add(new int[] { i, 0 });
      visited_pac[i][0] = true;
    }
    for (int i = 1; i < heights[0].length; i++) {
      q.add(new int[] { 0, i });
      visited_pac[0][i] = true;
    }
    int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    while (!q.isEmpty()) {
      int[] cur = q.poll();
      for (int[] dir : directions) {
        int i = dir[0] + cur[0];
        int j = dir[1] + cur[1];
        if (i >= 0 && i < heights.length && j >= 0 && j < heights[0].length && !visited_pac[i][j]
            && heights[cur[0]][cur[1]] <= heights[i][j]) {
          visited_pac[i][j] = true;
          q.add(new int[] { i, j });
        }
      }
    }

    for (int i = 0; i < heights.length; i++) {
      q.add(new int[] { i, heights[0].length - 1 });
      visited_atl[i][heights[0].length - 1] = true;
    }
    for (int i = 0; i < heights[0].length; i++) {
      q.add(new int[] { heights.length - 1, i });
      visited_atl[heights.length - 1][i] = true;
    }
    while (!q.isEmpty()) {
      int[] cur = q.poll();
      for (int[] dir : directions) {
        int i = dir[0] + cur[0];
        int j = dir[1] + cur[1];
        if (i >= 0 && i < heights.length && j >= 0 && j < heights[0].length && !visited_atl[i][j]
            && heights[cur[0]][cur[1]] <= heights[i][j]) {
          visited_atl[i][j] = true;
          q.add(new int[] { i, j });
        }
      }
    }

    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < heights.length; i++) {
      for (int j = 0; j < heights[0].length; j++) {
        if (visited_atl[i][j] && visited_pac[i][j]) {
          List<Integer> cell = new ArrayList<>();
          cell.add(i);
          cell.add(j);
          res.add(cell);
        }
      }
    }
    return res;
  }
}