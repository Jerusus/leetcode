class Solution {
    public int minFallingPathSum(int[][] A) {
        if (A.length == 1) {
            return A[0][0];
        }

        int[][] dp = new int[A.length][A[0].length];
        
        // set up the last row
        for (int i = 0; i < A[A.length-1].length; i++) {
            dp[A.length-1][i] = A[A.length-1][i];
        }

        // set up all other rows
        for (int i = A.length - 2; i >= 0; i--) {
            for (int j = 0; j < A[i].length; j++) {
                if (j == 0) {
                    // two
                    int min = Math.min(dp[i+1][j],dp[i+1][j+1]);
                    dp[i][j] = A[i][j] + min;
                } else if (j == A[i].length - 1) {
                    // two
                    int min = Math.min(dp[i+1][j],dp[i+1][j-1]);
                    dp[i][j] = A[i][j] + min;
                } else {
                    // three
                    int min = Math.min(dp[i+1][j],dp[i+1][j+1]);
                    min = Math.min(min,dp[i+1][j-1]);
                    dp[i][j] = A[i][j] + min;
                }
            }
        }

        // return min value
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A[0].length; i++) {
            min = Math.min(min,dp[0][i]);
        }
        return min;
    }

    public static void minFallingPathSum(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rob(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }
}
