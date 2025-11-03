class Solution {
    public int dominantIndex(int[] nums) {
        int max=0;
        int secondMax=0;
        int idx=0;
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            if(num>max) {
                secondMax=max;
                max=num;
                idx=i;
            }
            if(num>secondMax && num<max){
                secondMax=num;
            }
        }
        return max >= 2 * secondMax ? idx : -1;
    }
}