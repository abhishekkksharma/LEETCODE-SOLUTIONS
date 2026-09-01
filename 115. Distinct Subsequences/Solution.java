class Solution {
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        // int[][] dp=new int[n][m];
        // for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        // return helper(s,t,n-1,m-1,dp);
        return tabulation(s,t,n,m);
    }
    private int helper(String s,String t,int i,int j,int[][] dp){
        if(i<0 && j<0 || j<0) return 1;
        if(i<0 && j>=0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int ans=0;
        if(s.charAt(i)==t.charAt(j)){
            ans=helper(s,t,i-1,j-1,dp)+helper(s,t,i-1,j,dp);
        }else{
            ans+=helper(s,t,i-1,j,dp);
        }
        return dp[i][j]=ans;
    }
    private int tabulation(String s,String t,int n,int m){
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++) dp[i][0]=1;
        // for(int j=0;j<=m;j++) dp[0][j]=0; // no need
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }
}