class Solution {
  public int islandPerimeter(int[][] grid) {
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          count += getSides(grid, i, j);
        }
      }
    }
    return count;
  }

  public int getSides(int[][] grid, int i, int j) {
    int sides = 4;
    if (isIsland(grid, i + 1, j)) {
      sides--;
    }
    if (isIsland(grid, i, j + 1)) {
      sides--;
    }
    if (isIsland(grid, i - 1, j)) {
      sides--;
    }
    if (isIsland(grid, i, j - 1)) {
      sides--;
    }

    return sides;
  }

  public boolean isIsland(int[][] grid, int i, int j) {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
      return false;
    }
    return grid[i][j] == 1;
  }
}