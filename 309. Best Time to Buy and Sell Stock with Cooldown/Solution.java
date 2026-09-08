class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n+1][3];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(prices,0,1,dp);
    }
    private int helper(int[] prices,int i,int buy,int[][] dp){
        if(i>=prices.length ) return 0;
        if(dp[i][buy]!=-1) return dp[i][buy];
        int profit=0;
        if(buy==1 ){
            //buy or skip
            profit=Math.max(
                -prices[i]+helper(prices,i+1,0,dp),
                0+helper(prices,i+1,1,dp));
        }else{
            //sell or hold
            profit=Math.max(
                prices[i]+helper(prices,i+2,1,dp),
                0+helper(prices,i+1,0,dp));
        }
        return dp[i][buy]=profit;
    }
}