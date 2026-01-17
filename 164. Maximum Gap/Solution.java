class Solution {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        if(n<=1) return 0;
        int maxDiff = 0;
        for(int i=0;i<n-1;i++){
            int diff = Math.abs(nums[i+1]-nums[i]);
            if(diff>maxDiff && diff>0) maxDiff = diff;
        }
        return maxDiff;
    }
}