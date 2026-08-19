class Solution {
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][][] dp=new int[n][m][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<m;k++) dp[i][j][k]=-1;
            }
        }
        return solve(grid,0,0,m-1,dp);
    }
    private int solve(int[][] grid,int i,int j1,int j2,int[][][] dp){
        if(i>=grid.length || j1>=grid[0].length || j2>=grid[0].length || j1<0 || j2<0) return -1_000_000_000;
        if(i==grid.length-1) {
            if(j1==j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }
        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];

        int cherries=grid[i][j1];
        if(j1!=j2) cherries+=grid[i][j2];
        int ans=-1_000_000_000;
        for(int d1=-1;d1<=1;d1++){
            for(int d2=-1;d2<=1;d2++){
                ans=Math.max(ans,solve(grid,i+1,j1+d1,j2+d2,dp));
            }
        }
        return dp[i][j1][j2]=cherries+ans;
    }
}