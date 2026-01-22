class Solution {
    public int maximumDifference(int[] nums) {
        int min=nums[0];
        int maxDiff=-1;
        // for(int i=0;i<nums.length;i++){
        //     int j=nums.length-1;
        //     while(j>i){
        //         if(nums[j]>nums[i]){
        //             maxDiff=Math.max(maxDiff,nums[j]-nums[i]);
        //         }
        //         j--;
        //     }
        // }
        for(int num:nums){
            if(num>min){
                maxDiff=Math.max(maxDiff,num-min);
            }else{
                min=num;
            }
        }
        return maxDiff;
    }
}