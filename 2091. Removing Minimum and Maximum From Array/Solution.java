class Solution {
    public int minimumDeletions(int[] nums) {
        int minIdx=0;
        int maxIdx=0;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            if(num<min){
                min=num;
                minIdx=i;
            }
            if(num>max){
                max=num;
                maxIdx=i;
            }
        }
        int n=nums.length;
        int left=Math.max(minIdx,maxIdx)+1;
        int right=n - Math.min(minIdx, maxIdx);
        int both = Math.min(minIdx, maxIdx) + 1 + n - Math.max(minIdx, maxIdx);
        return Math.min(left, Math.min(right, both));
    }
}