class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    // recurse to wipe island
                    cleanIsland(grid, i, j);
                }
            }
        }
        return islands;
    }

    public void cleanIsland(char[][] grid, int i, int j) {
        if (i >= grid.length || i < 0 || j >= grid[i].length || j < 0) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        cleanIsland(grid, i+1, j);
        cleanIsland(grid, i, j+1);
        cleanIsland(grid, i-1, j);
        cleanIsland(grid, i, j-1);
    }
}