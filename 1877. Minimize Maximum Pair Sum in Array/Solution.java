class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int start=0;
        int last=nums.length-1;
        int max=0;
        while(start<last){
            int sum=nums[start]+nums[last];
            max=Math.max(max,sum);
            start++;
            last--;
        }
        return max;
    }
}