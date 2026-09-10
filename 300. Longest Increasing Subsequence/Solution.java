class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][n+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return helper(nums,0,-1,dp);
    }
    private int helper(int[] nums,int i,int prevI,int[][] dp){
        if(i==nums.length) return 0;
        if(dp[i][prevI+1]!=-1) return dp[i][prevI+1];
        int ans = 0;
        // not take
        ans = 0 + helper(nums,i+1,prevI,dp);
        // take
        if(prevI==-1 || nums[i]>nums[prevI]){
            ans=Math.max(ans,1+helper(nums,i+1,i,dp));
        }
        return dp[i][prevI+1]=ans;
    }
}