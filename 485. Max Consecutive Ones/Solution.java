class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount=0;
        int count=0;
        for(int num : nums){
            if(num==0) count=0;
            if(num==1) count++;
            if(count>maxCount) maxCount=count;
        }
        return maxCount;
    }
}