class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        // return rec(grid, 0, 0, n, m);
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        // return dpSol(grid, 0, 0, n, m,dp);
        return tabulationSol(grid,n,m,dp);
    }

    private int rec(int[][] grid, int i, int j, int n, int m) {
        if (i >= n || j >= m) return 1_000_000_000;
        if (i == n - 1 && j == m - 1)
            return grid[i][j];
        int down = rec(grid, i + 1, j, n, m) + grid[i][j];
        int right = rec(grid, i, j + 1, n, m) + grid[i][j];
        return Math.min(down, right);
    }

    private int dpSol(int[][] grid, int i, int j, int n, int m, int[][] dp) {
        if (i >= n || j >= m) return 1_000_000_000;
        if (i == n - 1 && j == m - 1)
            return grid[i][j];
        if (dp[i][j] != -1)
            return dp[i][j];
        int down = dpSol(grid, i + 1, j, n, m, dp) + grid[i][j];
        int right = dpSol(grid, i, j + 1, n, m, dp) + grid[i][j];
        return dp[i][j] = Math.min(down, right);
    }

    private int tabulationSol(int[][] grid, int n, int m, int[][] dp){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0) dp[i][j]=grid[i][j];
                else{
                    int up=1_000_000_000;
                    int left=1_000_000_000;
                    if(i>0) up=dp[i-1][j];
                    if(j>0) left=dp[i][j-1];
                    dp[i][j] = Math.min(up, left) + grid[i][j];
                }
            }
        }
        return dp[n-1][m-1];
    }
}