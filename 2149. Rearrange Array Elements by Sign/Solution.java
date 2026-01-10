class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int[] pos=new int[n/2];
        int[] neg=new int[n/2];
        int p=0;
        int k=0;
        for(int num:nums){
            if(num<0){
                neg[k++]=num;
            }else{
                pos[p++]=num;
            }
        }
        p=0;
        k=0;
        for(int i=0;i<n;i+=2){
            nums[i]=pos[p++];
            nums[i+1]=neg[k++];
        }
        return nums;
    }
}