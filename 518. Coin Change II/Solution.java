class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        // for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        // return helper(coins,n-1,amount,dp);
        return tabu(coins,n,amount,dp);
    }
    private int helper(int[] coins,int idx,int target,int[][] dp){
        if(target==0) return 1;
        if(idx==0){
            if(target%coins[0]==0) return 1;
            return 0;
        }
        if(dp[idx][target]!=-1) return dp[idx][target];
        int notTake = helper(coins,idx-1,target,dp);
        int take=0;
        if(coins[idx]<=target){
            take=helper(coins,idx,target-coins[idx],dp);
        }
        return dp[idx][target]=notTake+take;
    }
    private int tabu(int[] coins,int n,int target,int[][] dp){
        for(int T=0;T<=target;T++){
            dp[0][T]=(T%coins[0]==0) ? 1:0;
        }
        for(int i=1;i<n;i++){
            for(int T=0;T<=target;T++){
                int notTake = dp[i-1][T];
                int take=0;
                if(coins[i]<=T){
                    take=dp[i][T - coins[i]];
                }
                dp[i][T]=notTake+take;
            }
        }
        return dp[n-1][target];
    }
}