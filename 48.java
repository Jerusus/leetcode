class Solution {
    public void rotate(int[][] matrix) {
        int l = matrix.length;
        int e = l % 2; // for odd vs even
        int hl = l / 2;
        int k = l - 1; // length for index
        for (int i = 0; i < hl; i++) {
            for (int j = 0; j < hl + e; j++) {
                int a = matrix[i][j];
                int b = matrix[j][k-i];
                int c = matrix[k-i][k-j];
                int d = matrix[k-j][i];
                matrix[i][j] = d;
                matrix[j][k-i] = a;
                matrix[k-i][k-j] = b;
                matrix[k-j][i] = c;
            }
        }
    }
}