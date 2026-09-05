class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int min=nums[n-1];
        int[] mins = new int[n];
        for(int i=n-1;i>=0;i--){
            min=Math.min(min,nums[i]);
            mins[i]=min;
        }
        int max=nums[0];
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
            int diff=max-mins[i];
            if(diff<=k) return i;
        }
        return -1;
    }
}