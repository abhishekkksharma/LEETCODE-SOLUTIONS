class Solution {
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        int[][] dp=new int[n][m];
        //store 1 for true, 0 for false, -1 for unvisited
        // for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);

        // return helper(s,p,n-1,m-1,dp);
        return tabu(s,p,n,m);
    }
    private boolean helper(String s,String p,int i,int j,int[][] dp){
        //base cases
        if(i<0 && j<0) return true;
        if(i<0 && j>=0){
            for(int k=0;k<=j;k++){
                if(p.charAt(k) != '*') return false;
            }
            return true;
        }
        if (j < 0) {
            return false;
        }

        if(dp[i][j]!=-1) return dp[i][j]==1;
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
            boolean result = helper(s, p, i - 1, j - 1, dp);

            dp[i][j] = result ? 1 : 0;

            return result;
        }
        if(p.charAt(j)=='*'){
            boolean ignoreStar = helper(s,p,i,j-1,dp);
            boolean acceptStar = helper(s,p,i-1,j,dp);
            dp[i][j] = (ignoreStar || acceptStar) ? 1:0;
            return ignoreStar || acceptStar;
        }
        dp[i][j] = 0;
        return false;
    }
    private boolean tabu(String s,String p,int n,int m){
        boolean[][] dp=new boolean[n+1][m+1];
        dp[0][0]=true;
        for(int j=1;j<=m;j++){
            if(p.charAt(j-1)=='*') dp[0][j]=dp[0][j-1];
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }else if(p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[n][m];
    }
}