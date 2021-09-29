import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> res = new ArrayList<>();
    int i = 0, j = 0;
    res.add(matrix[i][j]);
    matrix[i][j] = 101;
    while (res.size() < matrix.length * matrix[0].length) {
      while (true) {
        if (invalid(i, j + 1, matrix)) {
          break;
        }
        j++;
        res.add(matrix[i][j]);
        matrix[i][j] = 101;
      }
      while (true) {
        if (invalid(i + 1, j, matrix)) {
          break;
        }
        i++;
        res.add(matrix[i][j]);
        matrix[i][j] = 101;
      }
      while (true) {
        if (invalid(i, j - 1, matrix)) {
          break;
        }
        j--;
        res.add(matrix[i][j]);
        matrix[i][j] = 101;
      }
      while (true) {
        if (invalid(i - 1, j, matrix)) {
          break;
        }
        i--;
        res.add(matrix[i][j]);
        matrix[i][j] = 101;
      }
    }
    return res;
  }

  boolean invalid(int i, int j, int[][] matrix) {
    return i >= matrix.length || i < 0 || j >= matrix[0].length || j < 0 || matrix[i][j] == 101;
  }
}