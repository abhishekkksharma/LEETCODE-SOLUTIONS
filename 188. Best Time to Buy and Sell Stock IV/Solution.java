class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        // int[][][] dp = new int[n][2][k + 1];
        // for (int i = 0; i < n; i++) {
        //     for (int buy = 0; buy < 2; buy++) {
        //         Arrays.fill(dp[i][buy], -1);
        //     }
        // }
        // return helper(prices, 0, 1, k, dp);
        return tabu(prices,k,n);
    }

    private int helper(int[] prices, int i, int buy, int k, int[][][] dp) {
        if (i == prices.length || k == 0)
            return 0;
        if (dp[i][buy][k] != -1)
            return dp[i][buy][k];
        int profit = 0;
        if (buy == 1) {
            //buy or skip
            profit = Math.max(
                    -prices[i] + helper(prices, i + 1, 0, k, dp),
                    0 + helper(prices, i + 1, 1, k, dp));
        } else {
            profit = Math.max(
                    prices[i] + helper(prices, i + 1, 1, k - 1, dp),
                    0 + helper(prices, i + 1, 0, k, dp));
        }
        return dp[i][buy][k] = profit;
    }

    private int tabu(int[] prices, int k,int n) {
        int[][][] dp = new int[n + 1][2][k + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy < 2; buy++) {
                for (int trans = 1; trans <= k; trans++) {
                    // Buy or skip
                    if (buy == 1) {
                        dp[i][buy][trans] = Math.max(
                                -prices[i] + dp[i + 1][0][trans],
                                dp[i + 1][1][trans]);
                    }
                    // Sell or hold
                    else {
                        dp[i][buy][trans] = Math.max(
                                prices[i] + dp[i + 1][1][trans - 1],
                                dp[i + 1][0][trans]);
                    }
                }
            }
        }

        return dp[0][1][k];
    }
}