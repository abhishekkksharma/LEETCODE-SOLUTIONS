class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);

        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, memo(matrix, n, 0, j, dp));
        }
        return ans;
    }

    private int memo(int[][] matrix, int n, int i, int j, int[][] dp) {
        if (j < 0 || j >= n) {
            return Integer.MAX_VALUE;
        }
        if (i == n - 1)
            return matrix[i][j];
        if (dp[i][j] != Integer.MAX_VALUE)
            return dp[i][j];
        int down =  memo(matrix, n, i + 1, j, dp);
        int downLeft =  memo(matrix, n, i + 1, j - 1, dp);
        int downRight =  memo(matrix, n, i + 1, j + 1, dp);
        return dp[i][j] = matrix[i][j] + Math.min(down, Math.min(downLeft, downRight));
    }
}