class Solution {
    public int maxProfit(int[] prices) {

        int profit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                profit+=prices[i]-prices[i-1];
            }
        }
        return profit;

        // int n=prices.length;
        // int[][] dp=new int[n][2];
        // for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        // return helper(prices,0,1,dp);
    }
    private int helper(int[] prices,int i,int buy,int[][] dp){
        if(i==prices.length) return 0;
        if(dp[i][buy]!=-1) return dp[i][buy];
        int profit=0;
        //if we buy
        if(buy==1){
            //buy condition
            profit = Math.max(-prices[i] + helper(prices,i+1 //take
                                ,0,dp),0+helper(prices,i+1,1,dp)); //not take
        }else{
            //sell condition
            profit = Math.max(prices[i] + helper(prices,i+1,1,dp), 0 + helper(prices,i+1,0,dp));
        }
        return dp[i][buy]=profit;
    }
}