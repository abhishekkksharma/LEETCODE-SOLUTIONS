class Solution {
    public void sortColors(int[] nums) {
        int start=0;
        int last=nums.length-1;
        int i=0;
        while( i<=last){
            if(nums[i]==0){
                swap(nums,start,i);
                start++;
                i++;
            }else if(nums[i]==2){
                swap(nums,last,i);
                last--;
            }else{
                i++;
            }
        }
    }
    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}