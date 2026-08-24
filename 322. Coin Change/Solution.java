class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        // for(int i=0;i<n;i++) Arrays.fill(dp[i],-1); 
        // int ans = helper(coins, n - 1, amount, dp);

        // return ans >= 1_000_000_000 ? -1 : ans;
        return tabu(coins,amount,dp);
    }
    private int helper(int[] coins,int idx,int target,int[][] dp){
        //base case
        if(target==0) return 0;
        if(idx==0){
            if(target%coins[0]==0) return target/coins[0];
            return 1_000_000_000;
        }
        if(dp[idx][target]!=-1) return dp[idx][target];
        int notTake = 0+helper(coins,idx-1,target,dp);
        int take=1_000_000_000;
        if(coins[idx]<=target){
            take = 1+ helper(coins,idx,target-coins[idx],dp);
        }
        return dp[idx][target]=Math.min(notTake,take);
    }
    private int tabu(int[] coins,int target,int[][] dp){
        int n=coins.length;
        for(int T=0;T<=target;T++){
            if(T%coins[0]==0) dp[0][T]=T/coins[0];
            else dp[0][T]=1_000_000_000;
        }
        for(int idx=1;idx<n;idx++){
            for(int T=0;T<=target;T++){
                int notTake = 0+dp[idx-1][T];
                int take=1_000_000_000;
                if(coins[idx]<=T){
                    take=1+dp[idx][T-coins[idx]];
                }
                dp[idx][T]=Math.min(notTake,take);
            }
        }
        int ans=dp[n-1][target];
        return ans==1_000_000_000?-1:ans;
    }
}