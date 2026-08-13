class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        if(obstacleGrid[n-1][m-1]==1) return 0;
        // int[][] dp=new int[obstacleGrid.length][m];
        // for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        // return path(0,0,n,m,obstacleGrid,dp);
        return tabu(obstacleGrid,n,m);
    }
    int path(int i,int j,int n,int m,int[][] obstacleGrid,int[][] dp){
        if(i>= n || j>=m) return 0;
        if(i==n-1 && j==m-1) return 1;
        if(obstacleGrid[i][j]==1) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int right=path(i,j+1,n,m,obstacleGrid,dp);
        int down=path(i+1,j,n,m,obstacleGrid,dp);
        return dp[i][j]=right+down;
    }
    int tabu(int[][] obstacleGrid,int n,int m){
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(obstacleGrid[i][j]==1) dp[i][j]=0;
                else if (i == 0 && j == 0) dp[i][j] = 1;
                else{
                    int up=0;
                    int left=0;
                    if(i>0) up=dp[i-1][j];
                    if(j>0) left=dp[i][j-1];
                    dp[i][j]=up+left;
                }
            }
        }
        return dp[n-1][m-1];
    }
}