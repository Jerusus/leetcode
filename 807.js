/**
 * @param {number[][]} grid
 * @return {number}
 */
var maxIncreaseKeepingSkyline = function(grid) {
    var s1 = new Array(grid.length).fill(0);
    var s2 = new Array(grid.length).fill(0);

    for (var i = 0; i < grid.length; i++) {
        var row = grid[i];
        for (var j = 0; j < row.length; j++) {
            if (grid[i][j] > s1[i]) {
                s1[i] = grid[i][j];
            }
        }
    }

    for (var i = 0; i < grid.length; i++) {
        var row = grid[i];
        for (var j = 0; j < row.length; j++) {
            if (grid[j][i] > s2[i]) {
                s2[i] = grid[j][i];
            }
        }
    }

    var res = 0;
    for (var i = 0; i < grid.length; i++) {
        var row = grid[i];
        for (var j = 0; j < row.length; j++) {
            var min = Math.min(s1[i], s2[j]);
            res += (min - grid[i][j]);
        }
    }

    return res;
};