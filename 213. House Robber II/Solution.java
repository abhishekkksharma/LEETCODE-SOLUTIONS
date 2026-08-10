class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if (n == 1) {
            return nums[0];
        }
        int first=robber(Arrays.copyOfRange(nums,1,n));
        int second = robber(Arrays.copyOfRange(nums,0,n-1));
        return Math.max(first,second);
    }
    private int robber(int[] nums){
        int n=nums.length;
        int prev=nums[0];
        int prev2=0;
        for(int i=1;i<n;i++){
            int take=nums[i];
            if(i>1) take+=prev2;
            int nottake= 0 +prev;
            int curr=Math.max(take,nottake);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
}