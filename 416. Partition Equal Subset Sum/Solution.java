class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int total=0;
        for(int i=0;i<n;i++){
            total+=nums[i];
        }
        if(total%2!=0) return false;
        int[][] dp=new int[n][total/2+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        
        return solve(nums,n-1,total/2,dp);
    }
    private boolean solve(int[] nums,int idx,int target,int[][] dp){
        if(target==0) return true;
        if(idx==0) return nums[0]==target;
        if(dp[idx][target]!=-1){
            return dp[idx][target]==1;
        }
        boolean notTake = solve(nums,idx-1,target,dp);
        boolean take=false;
        if(nums[idx]<=target){
            take=solve(nums,idx-1,target-nums[idx],dp);
        }
        dp[idx][target] = (take || notTake)?1:0;
        return take || notTake;
    }
}