class Solution {
    public boolean isMonotonic(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        if(nums[start]>nums[end]){
            for(int i=start;i<end;i++){
                if(nums[i]<nums[i+1]) return false;
            }
        }else{
            for(int i=start;i<end;i++){
                if(nums[i]>nums[i+1]) return false;
            }
        }
        return true;
    }
}